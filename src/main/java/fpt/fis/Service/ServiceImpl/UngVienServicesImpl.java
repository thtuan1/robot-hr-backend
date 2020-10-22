package fpt.fis.Service.ServiceImpl;

import fpt.fis.Service.UngVienService;
import fpt.fis.dto.UngVienDTO;
import fpt.fis.model.UngVien;
import fpt.fis.repository.UngVienRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UngVienServicesImpl implements UngVienService {
    @Autowired
    private UngVienRepository ungVienRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UngVienDTO> getAll() {
        List<UngVien> ungViens = ungVienRepository.getAll();
        List<UngVienDTO> ungVienDTOS = ungViens.stream().map(ungVien -> modelMapper
                .map(ungVien, UngVienDTO.class)).collect(Collectors.toList());
        return ungVienDTOS;
    }

    @Override
    public UngVien Updated(UngVien ungVien) {
        ungVienRepository.save(ungVien);
        return ungVienRepository.findById(ungVien.getId()).orElse(null);
    }

    @Override
    public UngVien Save(UngVien ungVien) {
        return ungVienRepository.save(ungVien);
    }

    @Override
    public UngVien Add(UngVien ungVien) {
//        ungVien1.setcMND(ungVien.getcMND());
//        ungVien1.setDiaChiCT(ungVien.getDiaChiCT());
//        ungVien1.setDiaChiHT(ungVien.getDiaChiHT());
//        ungVien1.setEmailCaNhan(ungVien.getEmailCaNhan());
//        ungVien1.setFlag(ungVien.isFlag());
//        ungVien1.setHonNhan(ungVien.isHonNhan());
//        ungVien1.setmST(ungVien.getmST());
//        ungVien1.setNgayCapBHXH(ungVien.getNgayCapBHXH());
//        ungVien1.setName(ungVien.getName());
//        ungVien1.setNgayCapCMND(ungVien.getNgayCapCMND());
//        ungVien1.setPhoneNumber(ungVien.getPhoneNumber());
//        ungVien1.setNgaySinh(ungVien.getNgaySinh());
        UngVien ungVien1 = ungVienRepository.save(ungVien);
        return ungVienRepository.findById(ungVien1.getId()).orElse(null);
    }

    @Override
    public UngVien deletedUngVien(@RequestParam("id") Long id) {
        UngVien ungVien1 = ungVienRepository.findById(id).orElse(null);
        ungVien1.setFlag(true);
        ungVienRepository.save(ungVien1);
        return ungVien1;
    }
    @Transactional
    public Optional<UngVien> getOne(Long id) {
//        Optional<UngVien> ungVien = ungVienRepository.findById(id);
        return ungVienRepository.findById(id);
    }
}
