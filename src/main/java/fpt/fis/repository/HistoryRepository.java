package fpt.fis.repository;

import fpt.fis.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Long> {
    @Query("from History")
    List<History> getAllHistory();
}
