package onegroup.onekids_excel_v3.entity.excel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import onegroup.onekids_excel_v3.entity.baseexcel.BaseExcel;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.entityv2.MaUser;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_kids_excel_t01")
public class OrderKidsExcelT01 extends BaseOrder {


    @JsonManagedReference
    @OneToMany(mappedBy = "orderKidsExcelT01", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<HistoryOrderKids> historyOrderKidsList;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_kids", nullable = false)
    private Kids kids;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_user", nullable = false)
    private MaUser maUser;

}
