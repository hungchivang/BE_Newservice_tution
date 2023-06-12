package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.ConfigAttendanceEmployeeSchool;
import onegroup.onekids_excel_v3.repository.attendance.ConfigAttendanceEmployeeSchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfigAttendanceEmployeeSchoolImpl {

    @Autowired
    ConfigAttendanceEmployeeSchoolRepo configAttendanceEmployeeSchoolRepo;

    public ConfigAttendanceEmployeeSchool findConfigAttendanceEmployeeSchoolByIdSchool(long idSchool){
        return configAttendanceEmployeeSchoolRepo.findConfigAttendanceEmployeeSchoolByIdSchool(idSchool);
    }
}
