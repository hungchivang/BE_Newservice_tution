package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceKidsRepo extends JpaRepository<AttendanceKids,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.ma_attendance_kids where id_kid =:id_kid and attendance_date between '2022-01-05' and '2022-02-04'")
    List<AttendanceKids> getAttendanceKidsByIdKidsAndMonth1(@Param("id_kid") long id_kid);
}
