package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.entity.common.AppConstant;
import onegroup.onekids_excel_v3.entity.excel.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ma_kids")
public class Kids extends BaseExcel<String> {
    @Column(length = 45, unique = true, nullable = false)
    private String kidCode;

    @Column(nullable = false)
    private String representation;

    @Column(length = 500)
    private String avatarKid;

    @Column(length = 500)
    private String avatarKidLocal;

    @Column(length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;

    @Column(length = 60, nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(length = 45)
    private String nickName;

    @Column(length = 45, nullable = false)
    private String gender;

    @Column(length = 1000)
    private String address;

    //địa chỉ thường trú
    private String permanentAddress;

    //dân tộc
    private String ethnic;

    @Column(length = 1000)
    private String note;

    @Column(length = 45)
    private String kidStatus;

    @Column(nullable = false)
    private LocalDate dateStart;

    //ngày bảo lưu
    private LocalDate dateRetain;

    //ngày nghỉ học
    private LocalDate dateLeave;

    @Column(columnDefinition = "bit default true", nullable = false)
    private boolean isActivated = AppConstant.APP_TRUE;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean historyView = AppConstant.APP_TRUE;

    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean smsSend = AppConstant.APP_FALSE;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean smsReceive = AppConstant.APP_TRUE;

    private String listIdCam;

    @Column(nullable = false)
    private Long idGrade;

    @Column(nullable = false)
    private Long idSchool;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int schoolCount;

    //start infor of parents
    private String fatherName;

    private LocalDate fatherBirthday;

    @Column(length = 15)
    private String fatherPhone;

    @Column(length = 50)
    private String fatherEmail;

    private String fatherJob;

    private String motherName;

    private LocalDate motherBirthday;

    @Column(length = 15)
    private String motherPhone;

    @Column(length = 50)
    private String motherEmail;

    private String motherJob;

    @Column(length = 500)
    private String picJsonUrlLocal;

    @Column(length = 500)
    private String picJsonUrl;

    //mã nhận từ sms hoặc khi tạo ban đầu
    @Column(nullable = false, length = 6)
    private String verifyCodeSchool;

    //mã từ hệ thống trong sysInfo
    @Column(nullable = false, length = 6)
    private String verifyCodeAdmin;

    /**
     * nếu outDate khác null thì có 2 TH
     * - nếu groupOutKids!=null: học sinh được chọn cho ra trường
     * - nếu groupOutKids==null: học sinh thực hiện thao tác xóa bằng tay: khi xóa ghi nhận groupOutKids=bằng ngày thực hiện thao tác xóa
     */
    private LocalDate outDate;

    //số định danh cá nhân
    private String identificationNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<AttendanceKids> attendanceKidsList;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<TotalKidsArrive> totalKidsArriveList;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT01> orderKidsExcelT01List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT02> orderKidsExcelT02List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT03> orderKidsExcelT03List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT04> orderKidsExcelT04List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT05> orderKidsExcelT05List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT06> orderKidsExcelT06List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT07> orderKidsExcelT07List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT08> orderKidsExcelT08List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT09> orderKidsExcelT09List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT10> orderKidsExcelT10List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT11> orderKidsExcelT11List;

    @JsonManagedReference
    @OneToMany(mappedBy = "kids", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT12> orderKidsExcelT12List;

}
