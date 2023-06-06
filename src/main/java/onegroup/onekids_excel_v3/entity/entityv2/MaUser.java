package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.entity.common.AppConstant;
import onegroup.onekids_excel_v3.entity.excel.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ma_user")
public class MaUser extends BaseExcel<String> {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String gender;

    //plus *NT, teacher *GV. parent *PH, trùng chưa xử lý đuôi A1,2,3. trùng đã xử lý đuôi B1,2,3
    @Column(nullable = false, unique = true)
    @Size(min = 6)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    @Size(min = 6)
    private String passwordShow;

    @Column(nullable = false, length = 15)
    private String phone;

    //lấy ở class ApptypeConstant
    @Column(nullable = false)
    private String appType;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean activated = AppConstant.APP_TRUE;

    private String activatedKey;

    private String resetPasswordKey;

    private LocalDateTime activatedDate;

    private LocalDateTime resetPasswordDate;

    private Integer deviceNumber;

    private Integer deviceLimit;

    private Integer deviceLoginedNumber;

    private LocalDate fromDate;

    private LocalDate toDate;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean unlimitTime = AppConstant.APP_TRUE;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean demoStatus = AppConstant.APP_TRUE;

    private LocalDate fromDemoDate;

    private LocalDate toDemoDate;

    /**
     * - với tài khoản có del_active=true
     * nếu ==null thì tài khoản còn tồn tại các thực thể con(phụ huynh->kids, employee->inforEmployeeSchool)
     * nếu !=null: tài khoản đã ko còn tồn tại thực thể con nào từ ngày ghi nhận
     * - khi khôi phục tài khoản thì set giá trị này về null
     */
    private LocalDate startDateDelete;

    /**
     * có 3 loại bị xóa hoàn toàn:
     * - manual: xóa bằng tay
     * - auto: xóa tự động
     * - handle: xóa khi xử lý trùng
     */
    private String typeDelete;

    //thời gian xóa tài khoản(del_active=false)
    private LocalDateTime timeDelete;

    //thời gian xóa hoàn toàn tài khoản(del_active=false and username+1)
    private LocalDateTime timeDeleteComplete;

    //true->tài khoản đang dùng thử
    private boolean trialStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<HistoryOrderKids> historyOrderKidsList;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<TotalKidsArrive> totalKidsArriveList;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT01> orderKidsExcelT01List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT02> orderKidsExcelT02List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT03> orderKidsExcelT03List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT04> orderKidsExcelT04List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT05> orderKidsExcelT05List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT06> orderKidsExcelT06List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT07> orderKidsExcelT07List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT08> orderKidsExcelT08List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT09> orderKidsExcelT09List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT10> orderKidsExcelT10List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT11> orderKidsExcelT11List;

    @JsonManagedReference
    @OneToMany(mappedBy = "maUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<OrderKidsExcelT12> orderKidsExcelT12List;

}
