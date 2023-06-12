package onegroup.onekids_excel_v3.entity.excel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "total_kids_arrive")
public class TotalKidsArrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

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

    @Column(name = "quantity_date")
    private Long quantityDate;

    @Column(name = "month")
    private Long month;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kids", nullable = false)
    private Kids kids;



}
