package fpt.fis.Service.ServiceImpl;

import fpt.fis.Service.ExtraInformationService;
import fpt.fis.dto.extraInformationDTO;
import fpt.fis.model.ExtraInformation;
import fpt.fis.model.UngVien;
import fpt.fis.repository.ExtraInformationReponsitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExtraInformationLmpl implements ExtraInformationService {
    @Autowired
    private ExtraInformationReponsitory extraInformationReponsitory;
    private ModelMapper modelMapper=new ModelMapper();


    @Override
    public List<extraInformationDTO> getAll() {
        List<ExtraInformation> extraInformations = extraInformationReponsitory.getAll();
        List<extraInformationDTO> extraInformationDTOS = extraInformations.stream().map(extraInformation -> modelMapper
                .map(extraInformation,extraInformationDTO.class)).collect(Collectors.toList());
        return extraInformationDTOS;
    }
    @Override
    public ExtraInformation addExtraInfo(ExtraInformation extraInformation)
    {
        ExtraInformation extraInformation1= extraInformationReponsitory.save(extraInformation);
        return extraInformationReponsitory.findById(extraInformation1.getId()).orElse(null);
    }
    @Override
    public ExtraInformation upadatedExtraInfo(ExtraInformation extraInformation) {
        extraInformationReponsitory.save(extraInformation);
        return extraInformationReponsitory.findById(extraInformation.getId()).orElse(null);
    }

    @Override
    public ExtraInformation SaveExtraInfo(ExtraInformation extraInformation) {
        return extraInformationReponsitory.save(extraInformation);
    }
    @Transactional
    public Optional<ExtraInformation> getOne(Long id) {
//        Optional<UngVien> ungVien = ungVienRepository.findById(id);
        return extraInformationReponsitory.findById(id);
    }

}
