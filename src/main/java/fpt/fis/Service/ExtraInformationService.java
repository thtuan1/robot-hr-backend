package fpt.fis.Service;

import fpt.fis.dto.extraInformationDTO;
import fpt.fis.model.ExtraInformation;
import fpt.fis.model.UngVien;

import java.util.List;
import java.util.Optional;

public interface ExtraInformationService {
    List<extraInformationDTO> getAll();

    ExtraInformation addExtraInfo(ExtraInformation extraInformation);

    ExtraInformation upadatedExtraInfo(ExtraInformation extraInformation);

    ExtraInformation SaveExtraInfo(ExtraInformation extraInformation);
    Optional<ExtraInformation> getOne(Long ID);
}
