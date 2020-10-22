package fpt.fis.Controller;

import fpt.fis.Service.NguoiThanService;
import fpt.fis.dto.NguoiThanDTO;
import fpt.fis.model.NguoiThan;
import fpt.fis.model.UngVien;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/nguoithan")
public class NguoiThanController {
    @Autowired
    private NguoiThanService nguoiThanService;

    @GetMapping(value = "/getAllNguoiThan")
    public List<NguoiThanDTO> getAllNguoiThan(Long ungvien_id) {
        return nguoiThanService.getAll(ungvien_id);
    }

    @PostMapping(value = "/updatedNguoiThan")
    public ResponseEntity<?> updatedNguoiThan(@RequestBody NguoiThan nguoiThan) {
        NguoiThan nguoiThan1 = nguoiThanService.Updated(nguoiThan);
        return new ResponseEntity<>(nguoiThan1, HttpStatus.OK);
    }

    @PostMapping(value = "/addNguoiThan")
    public ResponseEntity<?> addNguoiThan(@RequestBody NguoiThan nguoiThan) {
        NguoiThan nguoiThan1 = nguoiThanService.Updated(nguoiThan);
        return new ResponseEntity<>(nguoiThan1, HttpStatus.OK);
    }

    @PostMapping(value = "/deletedNguoiThan")
    public ResponseEntity<?> deletedNguoiThan(@RequestParam("id") Long id) {
        NguoiThan nguoiThan = nguoiThanService.deletedNguoiThan(id);
        return new ResponseEntity<>(nguoiThan, HttpStatus.OK);
    }
}
