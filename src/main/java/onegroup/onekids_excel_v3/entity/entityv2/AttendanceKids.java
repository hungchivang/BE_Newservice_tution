package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseNoAuditingExcel;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ma_attendance_kids")
public class AttendanceKids extends BaseNoAuditingExcel<String> {
    @Column(nullable = false)
    private Long idSchool;

    @Column(nullable = false)
    private Long idGrade;

    @Column(nullable = false)
    private LocalDate attendanceDate;

    //true có đơn xin nghỉ
    //false là không có đơn xin nghỉ
    private boolean absentStatus;

    //true là đã điểm danh đến, false là chưa điểm danh đến
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean attendanceArrive;

    //true là đã điểm danh về, false là chưa điểm danh về
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean attendanceLeave;

    //true là đã điểm danh ăn, false là chưa điểm danh ăn
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean attendanceEat;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class", nullable = false)
    private MaClass maClass;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kid", nullable = false)
    private Kids kids;

    @JsonManagedReference
    @OneToOne(mappedBy = "attendanceKids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private AttendanceArriveKids attendanceArriveKids;

    @JsonManagedReference
    @OneToOne(mappedBy = "attendanceKids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private AttendanceLeaveKids attendanceLeaveKids;

}
