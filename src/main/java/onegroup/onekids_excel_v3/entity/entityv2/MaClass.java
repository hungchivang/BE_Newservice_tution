package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.common.AppConstant;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ma_class")
public class MaClass extends BaseExcel<String> {

    @Column(nullable = false, unique = true)
    private String classCode;

    @Column(nullable = false)
    private String className;

    @Column(length = 3000)
    private String classDescription;

    @Column(nullable = false)
    private Long idSchool;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean morningSaturday= AppConstant.APP_TRUE;

    @Column(columnDefinition = "bit default 1")
    private boolean afternoonSaturday=AppConstant.APP_TRUE;

    @Column(columnDefinition = "bit default 1")
    private boolean eveningSaturday=AppConstant.APP_TRUE;

    @Column(columnDefinition = "bit default 0")
    private boolean sunday;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade grade;

    @JsonManagedReference
    @OneToMany(mappedBy = "maClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Kids> kidsList;

    @JsonManagedReference
    @OneToMany(mappedBy = "maClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<AttendanceKids> attendanceKidsList;

}
