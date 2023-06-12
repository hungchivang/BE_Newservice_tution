package onegroup.onekids_excel_v3.entity.entityv2;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseEntity;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static onegroup.onekids_excel_v3.common.AppConstant.*;


@Getter
@Setter
@Entity
@Table(name = "config_attendance_employee_school")
public class ConfigAttendanceEmployeeSchool extends BaseEntity<String> {

    private boolean morning = APP_TRUE;

    private boolean afternoon = APP_TRUE;

    private boolean evening;

    private boolean saturdayMorning = APP_TRUE;

    private boolean saturdayAfternoon = APP_TRUE;

    private boolean saturdayEvening;

    private boolean sundayMorning;

    private boolean sundayAfternoon;

    private boolean sundayEvening;

    private boolean breakfast;

    private boolean lunch = APP_TRUE;

    private boolean dinner;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_school", nullable = false)
    private School school;

    // thêm mới
    @Min(value = 1)
    @Max(value = 31)
    @Column(columnDefinition = "integer default 1")
    private int startDateOfAttendance;



}
