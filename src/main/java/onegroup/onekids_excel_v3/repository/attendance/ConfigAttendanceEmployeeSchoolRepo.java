package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.ConfigAttendanceEmployeeSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConfigAttendanceEmployeeSchoolRepo extends JpaRepository<ConfigAttendanceEmployeeSchool,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.config_attendance_employee_school where id_school=:id_school ")
    ConfigAttendanceEmployeeSchool findConfigAttendanceEmployeeSchoolByIdSchool(@Param("id_school") long idSchool);
}
