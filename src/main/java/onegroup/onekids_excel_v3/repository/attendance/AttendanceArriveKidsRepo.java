package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceArriveKids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceArriveKidsRepo extends JpaRepository<AttendanceArriveKids,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.attendance_arrive_kids where id_attendance =:id_attendance")
    AttendanceArriveKids getAttendanceArriveKidsByIdAttendanceKids(@Param("id_attendance") long id_attendance);
}
