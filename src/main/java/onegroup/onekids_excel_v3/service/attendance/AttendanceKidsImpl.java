package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import onegroup.onekids_excel_v3.repository.attendance.AttendanceKidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceKidsImpl {

    @Autowired
    AttendanceKidsRepo attendanceKidsRepo;

    public List<AttendanceKids> getAttendanceKidsByIdKidsAndMonth1(long id_kid,String startDay,String endDay){
        return attendanceKidsRepo.getAttendanceKidsByIdKidsAndMonth1(id_kid,startDay,endDay);
    }
}
