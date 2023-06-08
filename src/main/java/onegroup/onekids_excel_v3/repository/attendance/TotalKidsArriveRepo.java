package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TotalKidsArriveRepo extends JpaRepository<TotalKidsArrive,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.total_kids_arrive where id_kids =:id_kids")
    List<TotalKidsArrive> getTotalKidsArriveByIdKids(@Param("id_kids")long id_kids);

}
