package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalKidsArriveRepo extends JpaRepository<TotalKidsArrive,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.total_kids_arrive where id_kids =?1 and month =?2")
    TotalKidsArrive getAttendanceLeaveKidsByIdAttendanceKids(long id_kids,long month);


}
