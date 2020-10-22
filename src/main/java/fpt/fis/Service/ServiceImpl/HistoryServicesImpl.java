package fpt.fis.Service.ServiceImpl;

import fpt.fis.Service.HistoryService;
import fpt.fis.dto.HistoryDTO;
import fpt.fis.model.History;
import fpt.fis.repository.HistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServicesImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<HistoryDTO> getAll() {
        List<History> histories = historyRepository.getAllHistory();
        List<HistoryDTO> historyDTOS = histories.stream().map(history -> modelMapper
                .map(history, HistoryDTO.class)).collect(Collectors.toList());
        return historyDTOS;
    }
    @Override
    public History addHistory( History history)
    {
        History history1= historyRepository.save(history);
        return historyRepository.findById(history1.getId()).orElse(null);
    }

}
