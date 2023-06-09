package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.dto.MaClassAndDayOffClass;
import onegroup.onekids_excel_v3.entity.entityv2.AttendanceKids;
import onegroup.onekids_excel_v3.entity.entityv2.AttendanceLeaveKids;
import onegroup.onekids_excel_v3.entity.entityv2.DayOffClass;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import onegroup.onekids_excel_v3.repository.attendance.TotalKidsArriveRepo;
import onegroup.onekids_excel_v3.service.ClassService.DayOffClassImpl;
import onegroup.onekids_excel_v3.service.ClassService.MaClassImpl;
import onegroup.onekids_excel_v3.service.kidsService.KidExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static onegroup.onekids_excel_v3.common.AppConstant.TIME_LEAVE_KID_BLOCK;
import static onegroup.onekids_excel_v3.common.AppConstant.TIME_LEAVE_KID_DEFAULT;

@Service
public class TotalKidsArriveImpl {

    @Autowired
    TotalKidsArriveRepo totalKidsArriveRepo;

    @Autowired
    AttendanceKidsImpl attendanceKids;

    @Autowired
    KidExcelService kidExcelService;

    @Autowired
    AttendanceLeaveKidsImpl attendanceLeaveKids;

    @Autowired
    DayOffClassImpl dayOffClassImpl;

    @Autowired
    MaClassImpl maClassImpl;

    long arrive_t2t6 = 0L;
    long arrive_t7 = 0L;
    long arrive_cn = 0L;
    long absent_cp_t2t6 = 0L;
    long absent_kp_t2t6 = 0L;
    long absent_cp_t7 = 0L;
    long absent_kp_t7 = 0L;
    long leave_later = 0L;
    long quantity_date = 0L;

    @Scheduled(cron = "0 46 18 * * ?")
    public void cronJobTotalKidsArrive() {
        List<Kids> kidsList = kidExcelService.test();

        for (int i = 0; i < kidsList.size(); i++) {
            List<AttendanceKids> ListAttendanceKidsByMonth1OfOnceKid = attendanceKids.getAttendanceKidsByIdKidsAndMonth1(kidsList.get(i).getId());
            List<TotalKidsArrive> totalKidsArriveList = getTotalKidsArriveByIdKids(kidsList.get(i).getId());

            if (ListAttendanceKidsByMonth1OfOnceKid.size() == 0) {
                continue;
            } else {
                countQuantityDateAttendanceOfMonth(ListAttendanceKidsByMonth1OfOnceKid, ListAttendanceKidsByMonth1OfOnceKid.get(i).getMaClass().getId());
            }

            if (totalKidsArriveList.size() == 0) {
                totalKidsArriveRepo.save(new TotalKidsArrive((LocalDateTime.now()), arrive_t2t6, arrive_t7, arrive_cn, absent_cp_t2t6, absent_kp_t2t6, absent_cp_t7, absent_kp_t7, leave_later, quantity_date, (long) ListAttendanceKidsByMonth1OfOnceKid.get(0).getAttendanceDate().getMonth().getValue(), kidsList.get(i)));
                arrive_t2t6 = 0L;
                arrive_t7 = 0L;
                arrive_cn = 0L;
                absent_cp_t2t6 = 0L;
                absent_kp_t2t6 = 0L;
                absent_cp_t7 = 0L;
                absent_kp_t7 = 0L;
                leave_later = 0L;
            } else {
                for (int j = 0; j < totalKidsArriveList.size(); j++) {
                    if (totalKidsArriveList.get(j).getKids().getId().equals(kidsList.get(i).getId())
                            && totalKidsArriveList.get(j).getMonth() == (long) ListAttendanceKidsByMonth1OfOnceKid.get(0).getAttendanceDate().getMonth().getValue()) {
                        totalKidsArriveRepo.save(new TotalKidsArrive(totalKidsArriveList.get(j).getId(), (LocalDateTime.now()), arrive_t2t6, arrive_t7, arrive_cn, absent_cp_t2t6, absent_kp_t2t6, absent_cp_t7, absent_kp_t7, leave_later, quantity_date, (long) ListAttendanceKidsByMonth1OfOnceKid.get(0).getAttendanceDate().getMonth().getValue(), kidsList.get(i)));
                    }
                }
                arrive_t2t6 = 0L;
                arrive_t7 = 0L;
                arrive_cn = 0L;
                absent_cp_t2t6 = 0L;
                absent_kp_t2t6 = 0L;
                absent_cp_t7 = 0L;
                absent_kp_t7 = 0L;
                leave_later = 0L;
            }
        }
    }

    public void countQuantityDateAttendanceOfMonth(List<AttendanceKids> ListAttendanceKidsByMonth1OfOnceKid, long idClass) {
        List<DayOffClass> DayOffClassList = dayOffClassImpl.getDayOffClassByIdClass(idClass);

        //không tính ngày nghỉ mặc định
        for (int i = 0; i < ListAttendanceKidsByMonth1OfOnceKid.size(); i++) {
            LocalDate date = ListAttendanceKidsByMonth1OfOnceKid.get(i).getAttendanceDate();
            for (int k = 0; k < DayOffClassList.size(); k++) {
                if (date == DayOffClassList.get(k).getDate()) {
                    ListAttendanceKidsByMonth1OfOnceKid.remove(ListAttendanceKidsByMonth1OfOnceKid.get(i));
                }
            }
        }


        for (int j = 0; j < ListAttendanceKidsByMonth1OfOnceKid.size(); j++) {
            LocalDate date = ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceDate();
            DayOfWeek day = date.getDayOfWeek();
            int dayOfWeek = day.getValue();


            // bắt dầu tính tổng số ngày đi hoc, nghỉ,đến muộn
            //đi học
            if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5) && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                arrive_t2t6 = arrive_t2t6 + 1L;

            } else if ((dayOfWeek == 6)
                    && (maClassImpl.getMaClassByIdClass(idClass).isMorningSaturday() || maClassImpl.getMaClassByIdClass(idClass).isAfternoonSaturday() || maClassImpl.getMaClassByIdClass(idClass).isEveningSaturday())
                    && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                arrive_t7 = arrive_t7 + 1L;

            } else if ((dayOfWeek == 7)
                    && maClassImpl.getMaClassByIdClass(idClass).isSunday()
                    && (ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())) {
                arrive_cn = arrive_cn + 1L;

            }
            //nghỉ có phép t2-t6
            else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)

                    && (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())

                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes()))
            ) {
                absent_cp_t2t6 = absent_cp_t2t6 + 1L;
            }
            // nghỉ có phép t7
            else if ((dayOfWeek == 6)
                    && (maClassImpl.getMaClassByIdClass(idClass).isMorningSaturday() || maClassImpl.getMaClassByIdClass(idClass).isAfternoonSaturday() || maClassImpl.getMaClassByIdClass(idClass).isEveningSaturday())

                    && (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())

                    && ((ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorningYes() ||
                    ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoonYes() || ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEveningYes()))
            ) {
                absent_cp_t7 = absent_cp_t7 + 1L;
            }

            // nghỉ không phép t2-t6
            else if ((dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5)

                    && (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())

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
                absent_kp_t2t6 = absent_kp_t2t6 + 1L;
            }

            // nghỉ không phép t7
            else if ((dayOfWeek == 6)
                    && (maClassImpl.getMaClassByIdClass(idClass).isMorningSaturday() || maClassImpl.getMaClassByIdClass(idClass).isAfternoonSaturday() || maClassImpl.getMaClassByIdClass(idClass).isEveningSaturday())

                    && (!ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isMorning() &&
                    !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isAfternoon() && !ListAttendanceKidsByMonth1OfOnceKid.get(j).getAttendanceArriveKids().isEvening())

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
                absent_kp_t7 = absent_kp_t7 + 1L;
            }

            // tính số khối theo phút đón  muộn
            leave_later = leave_later + kidLeaveLate(attendanceLeaveKids.getAttendanceLeaveKidsByIdAttendanceKids(ListAttendanceKidsByMonth1OfOnceKid.get(j).getId()));

        }
    }

    public long kidLeaveLate(AttendanceLeaveKids attendanceLeaveKids) {
        long block = 0L;
        try {
            LocalTime timeLeaveKid = attendanceLeaveKids.getTimeLeaveKid();
            if (timeLeaveKid == null) {
                return block;
            }
            long hour = timeLeaveKid.getHour() - 1 - TIME_LEAVE_KID_DEFAULT.getHour();
            long minute = timeLeaveKid.getMinute() - TIME_LEAVE_KID_DEFAULT.getMinute();

            if (hour > 0) {
                minute = minute + (hour * 60);
                return (minute / TIME_LEAVE_KID_BLOCK) + block;
            } else if (hour == 0) {
                return (minute / TIME_LEAVE_KID_BLOCK) + block;
            } else {
                return block;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            return block;
        }
    }

    public List<TotalKidsArrive> getTotalKidsArriveByIdKids(long id_kid) {
        return totalKidsArriveRepo.getTotalKidsArriveByIdKids(id_kid);
    }
}
