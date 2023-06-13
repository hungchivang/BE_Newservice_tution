package onegroup.onekids_excel_v3.entity.entityv2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class CycleMoney extends BaseEntity<String> {
    //default, custom
    @Column(nullable = false)
    private String typeFees;

    private int startDateFees;

    private int endDateFees;

    //range1, range2
    @Column(nullable = false)
    private String rangeFees;


    @Column(nullable = false)
    private String typeSalary;

    private int startDateSalary;

    private int endDateSalary;

    @Column(nullable = false)
    private String rangeSalary;

    //tiền thừa, thiếu khi thanh toán hóa đơn sẽ vào: MONEY_WALLET, MONEY_MONTH
    @Column(nullable = false, columnDefinition = "varchar(255) default 'MONEY_WALLET'")
    private String transferMoneyType;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_school", nullable = false, unique = true)
    private School school;

}
