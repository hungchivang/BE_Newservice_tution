package onegroup.onekids_excel_v3.repository.Import;

import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface TotalKidArriveRepo extends JpaRepository<TotalKidsArrive, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.total_kids_arrive where id_kids =:id_kid and month =:month ")
    TotalKidsArrive getTotalKidsArriveByIdKidsAndMonth(@Param("id_kid") long id, @Param("month") long month);



}
