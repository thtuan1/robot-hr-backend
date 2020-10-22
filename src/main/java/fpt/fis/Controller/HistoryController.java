package fpt.fis.Controller;


import fpt.fis.Service.HistoryService;
import fpt.fis.Service.NguoiThanService;
import fpt.fis.dto.HistoryDTO;
import fpt.fis.dto.NguoiThanDTO;
import fpt.fis.model.History;
import fpt.fis.model.NguoiThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/getAllHistory")
    public List<HistoryDTO> getAllHistory(){
        return historyService.getAll();
    }

    @PostMapping(value = "/addHistory")
    public ResponseEntity<?> addHistory(@RequestBody History history)
    {
        History history1= historyService.addHistory(history);
        return new ResponseEntity<>(history1, HttpStatus.OK);
    }
}
