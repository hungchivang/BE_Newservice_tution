package onegroup.onekids_excel_v3.entity.excel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.entityv2.MaUser;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "total_kids_arrive")
public class TotalKidsArrive extends BaseExcel<String> {
    @Column(name = "arrive_t2t6")
    private Long arriveT2t6;

    @Column(name = "arrive_t7")
    private Long arriveT7;

    @Column(name = "arrive_cn")
    private Long arriveCn;

    @Column(name = "absent_cp_t2t6")
    private Long absentCpT2t6;

    @Column(name = "absent_kp_t2t6")
    private Long absentKpT2t6;

    @Column(name = "absent_cp_t7")
    private Long absentCpT7;

    @Column(name = "absent_kp_t7")
    private Long absentKpT7;

    @Column(name = "leave_later")
    private Long leaveLater;

    @Column(name = "month")
    private Long month;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kids", nullable = false)
    private Kids kids;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private MaUser maUser;

}
