package fpt.fis.Controller;

import fpt.fis.Service.ExtraInformationService;
import fpt.fis.Service.NguoiThanService;
import fpt.fis.Service.UngVienService;
import fpt.fis.dto.UngVienDTO;
import fpt.fis.model.ExtraInformation;
import fpt.fis.model.NguoiThan;
import fpt.fis.model.UngVien;
import fpt.fis.dto.extraInformationDTO;

import fpt.fis.repository.UngVienRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins ="http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping(value = "/ungvien")
public class UngVienController {
    @Autowired
    private UngVienService ungVienService;
    private UngVienRepository ungVienRepository;

    @Autowired
    private NguoiThanService nguoiThanService;
    @Autowired
    private ExtraInformationService extraInformationService;

    @GetMapping(value = "/getAllUngVien")
    public ResponseEntity<List<UngVienDTO>> getAll() {
        List<UngVienDTO> result = ungVienService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/updatedUngvien")
    public ResponseEntity<?> updatedUngvien(@RequestBody UngVien ungVien) {
        UngVien ungVien1 = ungVienService.Updated(ungVien);
        return new ResponseEntity<>(ungVien1, HttpStatus.OK);
    }

    @PostMapping(value = "/AddUngvien")
    public ResponseEntity<?> addUngvien(@RequestBody UngVien ungVien) {
        UngVien ungVien1 = ungVienService.Add(ungVien);
        return new ResponseEntity<>(ungVien1, HttpStatus.OK);
    }

    @PostMapping(value = "/deletedUngVien")
    public ResponseEntity<?> deletedUngVien(@RequestParam("id") Long id) {
        UngVien ungVien1 = ungVienService.deletedUngVien(id);
        return new ResponseEntity<>(ungVien1, HttpStatus.OK);
    }


    @PostMapping(value = "/import")
    public void Import(@RequestParam("file") MultipartFile inputFile) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(inputFile.getInputStream());
//import thong tin ung vien
        if (wb != null) {
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            Sheet sheet;
            sheet = wb.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            Row firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
           UngVien ungVien = new UngVien();
            String name = sheet.getRow(11).getCell(2).toString();
            String phone = sheet.getRow(11).getCell(5).toString();
            String date_sinh = sheet.getRow(12).getCell(2).toString();
           Date convertdate_sinh,convertdate_CMND,convertdate_MST,convertdate_BHXH,ConvertDateSinhNT,ConvertcontractendDate = new Date();
           SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String noiSinh = sheet.getRow(15).getCell(2).toString();
            String noiCapCMND = sheet.getRow(15).getCell(5).toString();
            String danToc = sheet.getRow(16).getCell(2).toString();
            String queQuan = sheet.getRow(16).getCell(5).toString();
            String quocTich = sheet.getRow(17).getCell(2).toString();
            String diachiTC = sheet.getRow(18).getCell(2).toString();
            String diaChiHT = sheet.getRow(19).getCell(2).toString();
            Long soTK = Long.parseLong(sheet.getRow(20).getCell(2).toString());
            String tenNH = sheet.getRow(20).getCell(4).toString();
            String date_MST = sheet.getRow(21).getCell(4).toString();
            if(sheet.getRow(21).getCell(2).toString()!="")
            {
                Long maST = Long.parseLong(sheet.getRow(21).getCell(2).toString());
                ungVien.setmST(maST);
                try {
                    convertdate_MST = formatter.parse(date_MST);
                    ungVien.setNgayCapMST(convertdate_MST);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            String emailCN = sheet.getRow(12).getCell(5).toString();
            Long soCMND = Long.parseLong(sheet.getRow(13).getCell(5).toString());
            String honNhan = sheet.getRow(14).getCell(2).toString();
            String date_CMND = sheet.getRow(14).getCell(5).toString();
            String date_BHXH = sheet.getRow(22).getCell(4).toString();

            String noiCapMST = sheet.getRow(21).getCell(6).toString();
            if(sheet.getRow(22).getCell(2).toString()!=""){
                Long soBHXH = Long.parseLong(sheet.getRow(22).getCell(2).toString());
                ungVien.setSoBHXH(soBHXH);
                try {
                    convertdate_BHXH = formatter.parse(date_BHXH);
                    ungVien.setNgayCapBHXH(convertdate_BHXH);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            String noiCapBHXH = sheet.getRow(22).getCell(6).toString();
            try {
                convertdate_sinh = formatter.parse(date_sinh);
                ungVien.setNgaySinh(convertdate_sinh);
                convertdate_CMND = formatter.parse(date_CMND);
                ungVien.setNgayCapCMND(convertdate_CMND);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ungVien.setName(name);
            ungVien.setPhoneNumber(phone);
            ungVien.setDanToc(danToc);

            ungVien.setEmailCaNhan(emailCN);
            ungVien.setNoiSinh(noiSinh);
            ungVien.setQueQuan(queQuan);
            ungVien.setQuocTich(quocTich);
            ungVien.setDiaChiCT(diachiTC);
            ungVien.setDiaChiHT(diaChiHT);
            ungVien.setHonNhan(honNhan);

            ungVien.setTenNganHang(tenNH);
            ungVien.setsTK(soTK);

            ungVien.setcMND(soCMND);

            ungVien.setNoiCapCMND(noiCapCMND);

            ungVien.setNoiCapMST(noiCapMST);

            ungVien.setNoiCapBHXH(noiCapBHXH);
            //nguoi than ung vien
            List<NguoiThan> nguoiThans = new ArrayList<>();
            int i = 113;
            while (sheet.getRow(i).getCell(1).toString()!="") {
                NguoiThan nguoiThan = new NguoiThan();
                String hoten = sheet.getRow(i).getCell(1).toString();
                String quanhe = sheet.getRow(i).getCell(3).toString();
                String dateSinh = sheet.getRow(i).getCell(4).toString();
                try {
                    ConvertDateSinhNT = formatter.parse(dateSinh);
                    nguoiThan.setNgaySinh(ConvertDateSinhNT);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String ngheNghiep = sheet.getRow(i).getCell(5).toString();
                String sDT = sheet.getRow(i).getCell(6).toString();
                nguoiThan.setName(hoten);
                nguoiThan.setRelationship(quanhe);
                nguoiThan.setNgheNghiep(ngheNghiep);
                nguoiThan.setSDT(sDT);
                nguoiThanService.Save(nguoiThan);
                nguoiThans.add(nguoiThan);
                i++;
            }
            ungVien.setNguoiThans(nguoiThans);
            //thong tin khac
            sheet = wb.getSheetAt(1);
                ExtraInformation extraInformation = new ExtraInformation();
                String phongBan = sheet.getRow(1).getCell(0).toString();
                String soHDLD = sheet.getRow(1).getCell(1).toString();
                String contractendDate = sheet.getRow(1).getCell(6).toString();
                try {
                    ConvertcontractendDate = formatter.parse(contractendDate);
                    extraInformation.setContractendDate(ConvertcontractendDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String loaiHD = sheet.getRow(1).getCell(2).toString();
                String heSoLuong = sheet.getRow(1).getCell(3).toString();
                String jodCode = sheet.getRow(1).getCell(4).toString();
                extraInformation.setPhongBan(phongBan);
                extraInformation.setSoHDLD(soHDLD);
                extraInformation.setLoaiHD(loaiHD);
                extraInformation.setHeSoLuong(heSoLuong);
                extraInformation.setJodCode(jodCode);
                extraInformationService.addExtraInfo(extraInformation);

            ungVien.setExtraInformation(extraInformation);
            ungVienService.Save(ungVien);

        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<ExtraInformation> getExtra(@PathVariable Long id) {
        Optional<ExtraInformation> ungVien=extraInformationService.getOne(id);
        return ungVien;

    }
}
