package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseNoAuditingExcel;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "attendance_leave_kids")
public class AttendanceLeaveKids extends BaseNoAuditingExcel<String> {
    //true là đã điểm danh về, false là chưa điểm danh về
    @Column(nullable = false)
    private boolean statusLeave;

    @Column(length = 3000)
    private String leaveContent = "";

    @Column(length = 500)
    private String leaveUrlPicture;

    @Column(length = 500)
    private String leaveUrlPictureLocal;

    private LocalTime timeLeaveKid;

    @Column(nullable = false)
    private int minutePickupLate;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_attendance", nullable = false)
    private AttendanceKids attendanceKids;

}
