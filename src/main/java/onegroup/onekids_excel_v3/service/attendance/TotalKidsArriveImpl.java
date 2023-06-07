package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.StatusExcel;
import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import onegroup.onekids_excel_v3.repository.attendance.TotalKidsArriveRepo;
import onegroup.onekids_excel_v3.service.kids.KidExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class TotalKidsArriveImpl {

    @Autowired
    TotalKidsArriveRepo totalKidsArriveRepo;

    @Autowired
    AttendanceKidsImpl attendanceKids;

    @Autowired
    KidExcelService kidExcelService;

    public void saveCronJobTotalKidsArrive(TotalKidsArrive totalKidsArrive) {
        int arrive_t2t6 = 0;
        int arrive_t7 = 0;
        int arrive_cn = 0;
        int absent_cp_t2t6 = 0;
        int absent_kp_t2t6 = 0;
        int absent_cp_t7 = 0;
        int absent_kp_t7 = 0;
        int leave_later = 0;

        List<Kids> kidsList = kidExcelService.findAll();
        for (int i = 0; i < kidsList.size(); i++) {
            List<AttendanceKids> ListAttendanceKidsByMonth1OfOnceKid = attendanceKids.getAttendanceKidsByIdKidsAndMonth1(kidsList.get(i).getId());
            LocalDate date = ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceDate();
            DayOfWeek day = date.getDayOfWeek();
            int dayOfWeek = day.getValue();

            // đi học
            if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5) && (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoon() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEvening())) {
                arrive_t2t6 = arrive_t2t6 + 1;

            } else if ((dayOfWeek == 6) && (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoon() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEvening())) {
                arrive_t7 = arrive_t7 + 1;

            } else if ((dayOfWeek == 7) && (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoon() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEvening())) {
                arrive_cn = arrive_cn + 1;

            }
            // nghỉ có phép t2-t6
            else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)
                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

            )) {
                absent_cp_t2t6 = absent_cp_t2t6 + 1;
            }
            // nghỉ có phép t7
            else if ((dayOfWeek == 6)
                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningYes() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningYes())

            )) {
                absent_cp_t7 = absent_cp_t7 + 1;
            }

            // nghỉ không phép t2-t6
            else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)
                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

            )) {
                absent_kp_t2t6 = absent_kp_t2t6 + 1;
            }

            // nghỉ không phép t7
            else if ((dayOfWeek == 6)
                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

                    || (ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())
                    || (!ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isMorningNo() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceArriveKids().isEveningNo())

            )) {
                absent_kp_t7 = absent_kp_t7 + 1;
            }
        }


        totalKidsArriveRepo.save(totalKidsArrive);
    }
}
