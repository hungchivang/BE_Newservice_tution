package onegroup.onekids_excel_v3.repository.kids;


import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KidsExcelRepo extends JpaRepository<Kids,Long> {

    List<Kids> findAllByIdSchool(long idSchool);

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.ma_kids where id_class = 100 and gender = 'Nữ'")
    List<Kids> test();
}
