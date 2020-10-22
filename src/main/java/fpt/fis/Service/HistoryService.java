package fpt.fis.Service;

import fpt.fis.dto.HistoryDTO;
import fpt.fis.model.History;

import java.util.List;

public interface HistoryService {
    List<HistoryDTO> getAll();

    History addHistory(History history);
}
