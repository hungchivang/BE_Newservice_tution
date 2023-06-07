package onegroup.onekids_excel_v3.repository.kids;


import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KidsExcelRepo extends JpaRepository<Kids,Long> {

    List<Kids> findAllByIdSchool(long idSchool);

    List<Kids> findAll();
}
