package fpt.fis.Service;

import fpt.fis.dto.UngVienDTO;
import fpt.fis.model.UngVien;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UngVienService {

    List<UngVienDTO> getAll();
    UngVien Add(UngVien ungVien);

    UngVien Updated(UngVien ungVien);

    UngVien Save(UngVien ungVien);
    UngVien deletedUngVien(@RequestParam("id ") Long id);
    Optional<UngVien> getOne(Long ID);
}
