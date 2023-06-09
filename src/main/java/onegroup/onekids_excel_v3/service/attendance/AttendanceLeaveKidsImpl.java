package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceLeaveKids;
import onegroup.onekids_excel_v3.repository.attendance.AttendanceLeaveKidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceLeaveKidsImpl {

    @Autowired
    AttendanceLeaveKidsRepo attendanceLeaveKidsRepo;

    public AttendanceLeaveKids getAttendanceLeaveKidsByIdAttendanceKids(long idAttendance){
        return attendanceLeaveKidsRepo.getAttendanceLeaveKidsByIdAttendanceKids(idAttendance);
    }
}
