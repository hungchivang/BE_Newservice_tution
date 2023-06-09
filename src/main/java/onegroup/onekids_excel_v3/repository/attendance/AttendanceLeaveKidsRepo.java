package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceLeaveKids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceLeaveKidsRepo extends JpaRepository<AttendanceLeaveKids,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.attendance_leave_kids where id_attendance =:id_attendance")
    AttendanceLeaveKids getAttendanceLeaveKidsByIdAttendanceKids(@Param("id_attendance") long id_attendance);
}
