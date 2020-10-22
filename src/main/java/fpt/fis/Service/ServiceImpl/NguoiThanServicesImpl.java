package fpt.fis.Service.ServiceImpl;

import fpt.fis.Service.NguoiThanService;
import fpt.fis.dto.NguoiThanDTO;
import fpt.fis.dto.UngVienDTO;
import fpt.fis.model.NguoiThan;
import fpt.fis.model.UngVien;
import fpt.fis.repository.NguoiThanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class NguoiThanServicesImpl implements NguoiThanService {
    @Autowired
    private NguoiThanRepository nguoiThanRepository;
    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<NguoiThanDTO> getAll(Long ungvien_id) {
        List<NguoiThan> nguoiThans = nguoiThanRepository.getAllNguoiThan(ungvien_id);
        List<NguoiThanDTO> nguoiThanDTOS = nguoiThans.stream().map(nguoiThan -> modelMapper
                .map(nguoiThan, NguoiThanDTO.class)).collect(Collectors.toList());
        return nguoiThanDTOS;
    }
    @Override
    public NguoiThan Updated(NguoiThan nguoiThan)
    {
       nguoiThanRepository.save(nguoiThan);
        return nguoiThanRepository.findById(nguoiThan.getId()).orElse(null);
    }
    @Override
    public NguoiThan Add(NguoiThan nguoiThan){
        NguoiThan nguoiThan1=nguoiThanRepository.save(nguoiThan);
        return nguoiThanRepository.findById(nguoiThan1.getId()).orElse(null);
    }
    @Override
    public NguoiThan deletedNguoiThan(@RequestParam("id") Long id)
    {
        NguoiThan nguoiThan= nguoiThanRepository.findById(id).orElse(null);
        nguoiThan.setFlag(true);
        nguoiThanRepository.save(nguoiThan);
        return nguoiThan;
    }
    @Override
    public NguoiThan Save(NguoiThan nguoiThan) {
        return nguoiThanRepository.save(nguoiThan);
    }
}
