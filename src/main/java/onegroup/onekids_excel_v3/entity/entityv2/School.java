package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.common.AppConstant;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ma_school")
public class School extends BaseExcel<String> {

    @Column(nullable = false, unique = true)
    private String schoolCode;

    private String schoolAvatar;

    private String schoolLocalAvatar;

    @Column(nullable = false)
    private String schoolName;

    @Column(columnDefinition = "TEXT")
    private String schoolDescription;

    @Column(nullable = false)
    private String schoolAddress;

    @Column(length = 15, nullable = false)
    private String schoolPhone;

    @Column(length = 50)
    private String schoolEmail;

    private String schoolWebsite;

    private String contactName1;

    private String contactDescription1;

    @Column(length = 15)
    private String contactPhone1;

    @Column(length = 50)
    private String contactEmail1;

    private String contactName2;

    private String contactDescription2;

    @Column(length = 15)
    private String contactPhone2;

    @Column(length = 50)
    private String contactEmail2;

    private String contactName3;

    private String contactDescription3;

    @Column(length = 15)
    private String contactPhone3;

    @Column(length = 50)
    private String contactEmail3;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean schoolActive = AppConstant.APP_TRUE;

    private long smsBudget;

    private LocalDateTime smsBudgetDate;

    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean smsActiveMore;

    private long smsUsed;

    private long smsTotal;

    private String idsmsBrand;

    private String namePhone1;

    private String namePhone2;

    private String namePhone3;

    private LocalDate demoStart;

    private LocalDate demoEnd;

    private LocalDate dateContractStart;

    private LocalDate dateContractEnd;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private boolean limitTime;

    private boolean limitDevice;

    private int numberDevice;

    //true->tài khoản đang dùng thử
    private boolean trialStatus;

    @Column(columnDefinition = "varchar(255) default 'D'", nullable = false)
    private String groupType = "D";

    @JsonManagedReference
    @OneToMany(mappedBy = "school", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Grade> gradeList;;

}
