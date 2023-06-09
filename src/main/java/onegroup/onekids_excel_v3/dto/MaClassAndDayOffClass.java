package onegroup.onekids_excel_v3.dto;

import java.time.LocalDate;


public interface MaClassAndDayOffClass {
    Long getIdDayOffClass();
    LocalDate getDate();
    Long getIdClass();
    Boolean getMorningSaturday();
    Boolean getAfternoonSaturday();
    Boolean getEveningSaturday();
    Boolean getSunday();
}
