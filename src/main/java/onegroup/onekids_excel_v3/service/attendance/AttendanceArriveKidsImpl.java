package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceArriveKids;
import onegroup.onekids_excel_v3.entity.entityv2.AttendanceLeaveKids;
import onegroup.onekids_excel_v3.repository.attendance.AttendanceArriveKidsRepo;
import onegroup.onekids_excel_v3.repository.attendance.AttendanceLeaveKidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceArriveKidsImpl {

    @Autowired
    AttendanceArriveKidsRepo attendanceArriveKidsRepo;

    public AttendanceArriveKids getAttendanceLeaveKidsByIdAttendanceKids(long idAttendance){
        return attendanceArriveKidsRepo.getAttendanceArriveKidsByIdAttendanceKids(idAttendance);
    }

}
