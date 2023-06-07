package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import onegroup.onekids_excel_v3.repository.attendance.TotalKidsArriveRepo;
import onegroup.onekids_excel_v3.service.kids.KidExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static onegroup.onekids_excel_v3.common.AppConstant.TIME_LEAVE_KID_DEFAULT;

@Service
public class TotalKidsArriveImpl {

    @Autowired
    TotalKidsArriveRepo totalKidsArriveRepo;

    @Autowired
    AttendanceKidsImpl attendanceKids;

    @Autowired
    KidExcelService kidExcelService;

    @Scheduled(cron = "0 0 3 * * ?")
    public void cronJobTotalKidsArrive() {
        long arrive_t2t6 = 0;
        long arrive_t7 = 0;
        long arrive_cn = 0;
        long absent_cp_t2t6 = 0;
        long absent_kp_t2t6 = 0;
        long absent_cp_t7 = 0;
        long absent_kp_t7 = 0;
        long leave_later = 0;

        TotalKidsArrive totalKidsArrive = new TotalKidsArrive();

        List<Kids> kidsList = kidExcelService.findAll();

        for (int i = 0; i < kidsList.size(); i++) {
            List<AttendanceKids> ListAttendanceKidsByMonth1OfOnceKid = attendanceKids.getAttendanceKidsByIdKidsAndMonth1(kidsList.get(i).getId());
            for (int j = 0; j < ListAttendanceKidsByMonth1OfOnceKid.size(); j++) {
                LocalDate date = ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceDate();
                DayOfWeek day = date.getDayOfWeek();
                int dayOfWeek = day.getValue();

                // đi học
                if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5) && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() ||
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                    arrive_t2t6 = arrive_t2t6 + 1;

                } else if ((dayOfWeek == 6) && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() ||
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                    arrive_t7 = arrive_t7 + 1;

                } else if ((dayOfWeek == 7) && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() ||
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                    arrive_cn = arrive_cn + 1;

                }
                // nghỉ có phép t2-t6
                else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)
                        && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() ||
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                )) {
                    absent_cp_t2t6 = absent_cp_t2t6 + 1;
                }
                // nghỉ có phép t7
                else if ((dayOfWeek == 6)
                        && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() ||
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes())
                )) {
                    absent_cp_t7 = absent_cp_t7 + 1;
                }

                // nghỉ không phép t2-t6
                else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)
                        && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                )) {
                    absent_kp_t2t6 = absent_kp_t2t6 + 1;
                }

                // nghỉ không phép t7
                else if ((dayOfWeek == 6)
                        && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                        || (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())
                        || (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningNo() &&
                        !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonNo() && ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningNo())

                )) {
                    absent_kp_t7 = absent_kp_t7 + 1;
                }

                leave_later = leave_later + kidLeaveLate(ListAttendanceKidsByMonth1OfOnceKid.get(j));
            }

            totalKidsArrive.getKids().setId(kidsList.get(i).getId());
            totalKidsArrive.setCreatedDate(LocalDateTime.now());
            totalKidsArrive.setArriveT2t6(arrive_t2t6);
            totalKidsArrive.setArriveT7(arrive_t7);
            totalKidsArrive.setArriveCn(arrive_cn);
            totalKidsArrive.setAbsentCpT2t6(absent_cp_t2t6);
            totalKidsArrive.setAbsentKpT2t6(absent_kp_t2t6);
            totalKidsArrive.setAbsentCpT7(absent_cp_t7);
            totalKidsArrive.setAbsentKpT7(absent_kp_t7);
            totalKidsArrive.setLeaveLater(leave_later);
            totalKidsArrive.setMonth((long) ListAttendanceKidsByMonth1OfOnceKid.get(0).getAttendanceDate().getMonth().getValue());

            totalKidsArriveRepo.save(totalKidsArrive);
        }

    }

    public long  kidLeaveLate(AttendanceKids attendanceKids){
        LocalTime timeLeaveKid =  attendanceKids.getAttendanceLeaveKids().getTimeLeaveKid();
        long hour = timeLeaveKid.getHour() - TIME_LEAVE_KID_DEFAULT.getHour();
        long minute = timeLeaveKid.getMinute() - TIME_LEAVE_KID_DEFAULT.getMinute();
        long block = 0;

        if(hour > 0){
            minute = minute + (hour * 60);
            return (minute % 10) + block;
        }else if(hour == 0){
            return (minute % 10) + block;
        }else {
            return block;
        }
    }
}
