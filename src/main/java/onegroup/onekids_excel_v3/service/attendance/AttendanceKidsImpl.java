package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import onegroup.onekids_excel_v3.repository.attendance.AttendanceKidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceKidsImpl {

    @Autowired
    AttendanceKidsRepo attendanceKidsRepo;

    public List<AttendanceKids> getAttendanceKidsByIdKidsAndMonth1(long id_kid){
        return attendanceKidsRepo.getAttendanceKidsByIdKidsAndMonth1(id_kid);
    }
}
