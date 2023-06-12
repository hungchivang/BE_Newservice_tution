package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.*;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static onegroup.onekids_excel_v3.common.AppConstant.TIME_LEAVE_KID_BLOCK;
import static onegroup.onekids_excel_v3.common.AppConstant.TIME_LEAVE_KID_DEFAULT;

@Service
public class TotalKidsArriveImpl {

    @Autowired
    TotalKidsArriveRepo totalKidsArriveRepo;

    @Autowired
    AttendanceKidsImpl attendanceKidsImpl;

    @Autowired
    KidExcelService kidExcelService;

    @Autowired
    AttendanceLeaveKidsImpl attendanceLeaveKidsImpl;

    @Autowired
    DayOffClassImpl dayOffClassImpl;

    @Autowired
    MaClassImpl maClassImpl;

    @Autowired
    ConfigAttendanceEmployeeSchoolImpl configAttendanceEmployeeSchoolImpl;


    long arrive_t2t6 = 0L;
    long arrive_t7 = 0L;
    long arrive_cn = 0L;
    long absent_cp_t2t6 = 0L;
    long absent_kp_t2t6 = 0L;
    long absent_cp_t7 = 0L;
    long absent_kp_t7 = 0L;
    long leave_later = 0L;
    String startDate;
    String endDate;

    @Scheduled(cron = "0 44 18 * * ?")
    public void saveTotalKidsArrive() {
        List<Kids> kidsList = kidExcelService.test();

        for (int months = 1; months <= 12 ; months++) {
            for (int i = 0; i < kidsList.size(); i++) {
                List<TotalKidsArrive> totalKidsArriveList = getTotalKidsArriveByIdKids(kidsList.get(i).getId());


                getStartDateAndEndDate(kidsList.get(i).getIdSchool(),months);
                List<AttendanceKids> ListAttendanceKidsByMonth1OfOnceKid = attendanceKidsImpl.getAttendanceKidsByIdKidsAndMonth1(kidsList.get(i).getId(), startDate, endDate);
                List<DayOffClass> DayOffClassList = dayOffClassImpl.getDayOffClassByIdClass(kidsList.get(i).getMaClass().getId(), startDate, endDate);


                //bỏ những ngày được nghỉ trong tuần
                ListAttendanceKidsByMonth1OfOnceKid = ListAttendanceKidsByMonth1OfOnceKid.stream()
                        .filter(item1 -> DayOffClassList.stream().noneMatch(item2 -> item2.getDate().equals(item1.getAttendanceDate())))
                        .collect(Collectors.toList());

                //bỏ những ngày được nghỉ t7, cn theo lich
                int finalI = i;
                ListAttendanceKidsByMonth1OfOnceKid = ListAttendanceKidsByMonth1OfOnceKid.stream()
                        .filter(item1 -> !(item1.getAttendanceDate().getDayOfWeek().getValue() == 7 && !maClassImpl.getMaClassByIdClass(kidsList.get(finalI).getMaClass().getId()).isSunday())
                                && !(item1.getAttendanceDate().getDayOfWeek().getValue() == 6 && !maClassImpl.getMaClassByIdClass(kidsList.get(finalI).getMaClass().getId()).isMorningSaturday() && !maClassImpl.getMaClassByIdClass(kidsList.get(finalI).getMaClass().getId()).isAfternoonSaturday() && !maClassImpl.getMaClassByIdClass(kidsList.get(finalI).getMaClass().getId()).isEveningSaturday()))
                        .collect(Collectors.toList());

                if (ListAttendanceKidsByMonth1OfOnceKid.size() == 0) {
                    continue;
                } else {
                    countQuantityDateAttendanceOfMonth(ListAttendanceKidsByMonth1OfOnceKid, ListAttendanceKidsByMonth1OfOnceKid.get(i).getMaClass().getId());
                }

                if(totalKidsArriveList.size() ==0) {
                    totalKidsArriveRepo.save(new TotalKidsArrive((LocalDateTime.now()), arrive_t2t6, arrive_t7, arrive_cn, absent_cp_t2t6, absent_kp_t2t6, absent_cp_t7, absent_kp_t7, leave_later, (long) ListAttendanceKidsByMonth1OfOnceKid.size(), (long) months, kidsList.get(i)));
                }else {
                    for (int j = 0; j < totalKidsArriveList.size(); j++) {
                        if (totalKidsArriveList.get(j).getKids().getId().equals(kidsList.get(i).getId())
                                && totalKidsArriveList.get(j).getMonth() == (long) months) {
                            totalKidsArriveRepo.save(new TotalKidsArrive(totalKidsArriveList.get(j).getId(), (LocalDateTime.now()), arrive_t2t6, arrive_t7, arrive_cn, absent_cp_t2t6, absent_kp_t2t6, absent_cp_t7, absent_kp_t7, leave_later, (long) ListAttendanceKidsByMonth1OfOnceKid.size(), (long) months, kidsList.get(i)));

                        }else {
                            totalKidsArriveRepo.save(new TotalKidsArrive((LocalDateTime.now()), arrive_t2t6, arrive_t7, arrive_cn, absent_cp_t2t6, absent_kp_t2t6, absent_cp_t7, absent_kp_t7, leave_later, (long) ListAttendanceKidsByMonth1OfOnceKid.size(), (long) months, kidsList.get(i)));
                        }
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
            leave_later = leave_later + kidLeaveLateOfDay(attendanceLeaveKidsImpl.getAttendanceLeaveKidsByIdAttendanceKids(ListAttendanceKidsByMonth1OfOnceKid.get(j).getId()));

        }
    }


    // đón muộn
    public long kidLeaveLateOfDay(AttendanceLeaveKids attendanceLeaveKids) {
        long block = 0L;
        try {
            LocalTime timeLeaveKid = attendanceLeaveKids.getTimeLeaveKid();
            if (timeLeaveKid == null) {
                return block;
            }
            long hour = timeLeaveKid.getHour() - TIME_LEAVE_KID_DEFAULT.getHour();
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

    // lấy ngày bắt đàu và kết thúc
    public void getStartDateAndEndDate(long idSchool, int month){

            ConfigAttendanceEmployeeSchool configAttendanceEmployeeSchool = configAttendanceEmployeeSchoolImpl.findConfigAttendanceEmployeeSchoolByIdSchool(idSchool);
            int startDayConfig = configAttendanceEmployeeSchool.getStartDateOfAttendance();
            int year = 2022;

            startDate = year + "-" + month + "-" + startDayConfig;

            if(startDayConfig == 1){
                if(month == 1 || month == 3 || month == 5|| month == 7|| month == 8|| month == 10|| month == 12){
                    endDate = year + "-" + month + "-" + 31;
                }else if(month == 4 || month == 6 || month == 9|| month == 11){
                    endDate = year + "-" + month + "-" + 30;
                }else {
                    if (checkYear(year)) {
                        endDate = year + "-" + month + "-" + 29;
                    } else {
                        endDate = year + "-" + month + "-" + 28;
                    }
                }

            }else if(month > 0 && month < 12){
                endDate = year + "-" + (month + 1) + "-" + (startDayConfig -1);
            }else if(month == 12){
                endDate = (year + 1) + "-" + 1 + "-" + (startDayConfig -1);
            }
    }


    public List<TotalKidsArrive> getTotalKidsArriveByIdKids(long id_kid) {
        return totalKidsArriveRepo.getTotalKidsArriveByIdKids(id_kid);
    }

    // check năm nhuận
    public boolean checkYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
