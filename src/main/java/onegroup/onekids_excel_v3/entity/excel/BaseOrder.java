package onegroup.onekids_excel_v3.entity.excel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import onegroup.onekids_excel_v3.common.AppConstant;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // id người tạo, lấy tự động
    @Column(nullable = false,name = "id_Created")
    @CreatedBy
    private Long idCreated;

    // tên người tạo, người dùng tự thêm vào
    @Column(name = "created_By")
    private String createdBy;

    // thời gian tạo, lấy tự động
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

    // id người sửa. lấy tự động
    @LastModifiedBy
    @Column(name = "id_Modified")
    private Long idModified;

    // 1 là hiện thị ra, 0 là ko hiện thị ra
    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean delActive = AppConstant.APP_TRUE;

    @Column(name = "order_hidden", columnDefinition = "bit default 0")
    private Boolean orderHidden;

    @Column(name = "kid_code")
    private String kidCode;

    @Column(name = "order_kid_code", length = 45, nullable = false)
    private String orderKidCode;

    @Column(name = "category")
    private String category;

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

    @Column(name = "before_money")
    private Double beforeMoney;


    @Column(name = "name_kt1")
    private String nameKt1;
    @Column(name = "money_kt1")
    private Double moneyKt1;
    @Column(name = "quantity_kt1")
    private Long quantityKt1;
    @Column(name = "price_kt1")
    private Double priceKt1;
    @Column(name = "discount_kt1")
    private Double discountKt1;

    @Column(name = "name_kt2")
    private String nameKt2;
    @Column(name = "money_kt2")
    private Double moneyKt2;
    @Column(name = "quantity_kt2")
    private Long quantityKt2;
    @Column(name = "price_kt2")
    private Double priceKt2;
    @Column(name = "discount_kt2")
    private Double discountKt2;

    @Column(name = "name_kt3")
    private String nameKt3;
    @Column(name = "money_kt3")
    private Double moneyKt3;
    @Column(name = "quantity_kt3")
    private Long quantityKt3;
    @Column(name = "price_kt3")
    private Double priceKt3;
    @Column(name = "discount_kt3")
    private Double discountKt3;

    @Column(name = "name_kt4")
    private String nameKt4;
    @Column(name = "money_kt4")
    private Double moneyKt4;
    @Column(name = "quantity_kt4")
    private Long quantityKt4;
    @Column(name = "price_kt4")
    private Double priceKt4;
    @Column(name = "discount_kt4")
    private Double discountKt4;

    @Column(name = "name_kt5")
    private String nameKt5;
    @Column(name = "money_kt5")
    private Double moneyKt5;
    @Column(name = "quantity_kt5")
    private Long quantityKt5;
    @Column(name = "price_kt5")
    private Double priceKt5;
    @Column(name = "discount_kt5")
    private Double discountKt5;

    @Column(name = "name_kt6")
    private String nameKt6;
    @Column(name = "money_kt6")
    private Double moneyKt6;
    @Column(name = "quantity_kt6")
    private Long quantityKt6;
    @Column(name = "price_kt6")
    private Double priceKt6;
    @Column(name = "discount_kt6")
    private Double discountKt6;

    @Column(name = "name_kt7")
    private String nameKt7;
    @Column(name = "money_kt7")
    private Double moneyKt7;
    @Column(name = "quantity_kt7")
    private Long quantityKt7;
    @Column(name = "price_kt7")
    private Double priceKt7;
    @Column(name = "discount_kt7")
    private Double discountKt7;

    @Column(name = "name_kt8")
    private String nameKt8;
    @Column(name = "money_kt8")
    private Double moneyKt8;
    @Column(name = "quantity_kt8")
    private Long quantityKt8;
    @Column(name = "price_kt8")
    private Double priceKt8;
    @Column(name = "discount_kt8")
    private Double discountKt8;

    @Column(name = "name_kt9")
    private String nameKt9;
    @Column(name = "money_kt9")
    private Double moneyKt9;
    @Column(name = "quantity_kt9")
    private Long quantityKt9;
    @Column(name = "price_kt9")
    private Double priceKt9;
    @Column(name = "discount_kt9")
    private Double discountKt9;

    @Column(name = "name_kt10")
    private String nameKt10;
    @Column(name = "money_kt10")
    private Double moneyKt10;
    @Column(name = "quantity_kt10")
    private Long quantityKt10;
    @Column(name = "price_kt10")
    private Double priceKt10;
    @Column(name = "discount_kt10")
    private Double discountKt10;

    @Column(name = "name_kt11")
    private String nameKt11;
    @Column(name = "money_kt11")
    private Double moneyKt11;
    @Column(name = "quantity_kt11")
    private Long quantityKt11;
    @Column(name = "price_kt11")
    private Double priceKt11;
    @Column(name = "discount_kt11")
    private Double discountKt11;

    @Column(name = "name_kt12")
    private String nameKt12;
    @Column(name = "money_kt12")
    private Double moneyKt12;
    @Column(name = "quantity_kt12")
    private Long quantityKt12;
    @Column(name = "price_kt12")
    private Double priceKt12;
    @Column(name = "discount_kt12")
    private Double discountKt12;

    @Column(name = "name_kt13")
    private String nameKt13;
    @Column(name = "money_kt13")
    private Double moneyKt13;
    @Column(name = "quantity_kt13")
    private Long quantityKt13;
    @Column(name = "price_kt13")
    private Double priceKt13;
    @Column(name = "discount_kt13")
    private Double discountKt13;

    @Column(name = "name_kt14")
    private String nameKt14;
    @Column(name = "money_kt14")
    private Double moneyKt14;
    @Column(name = "quantity_kt14")
    private Long quantityKt14;
    @Column(name = "price_kt14")
    private Double priceKt14;
    @Column(name = "discount_kt14")
    private Double discountKt14;

    @Column(name = "name_kt15")
    private String nameKt15;
    @Column(name = "money_kt15")
    private Double moneyKt15;
    @Column(name = "quantity_kt15")
    private Long quantityKt15;
    @Column(name = "price_kt15")
    private Double priceKt15;
    @Column(name = "discount_kt15")
    private Double discountKt15;

    @Column(name = "name_kt16")
    private String nameKt16;
    @Column(name = "money_kt16")
    private Double moneyKt16;
    @Column(name = "quantity_kt16")
    private Long quantityKt16;
    @Column(name = "price_kt16")
    private Double priceKt16;
    @Column(name = "discount_kt16")
    private Double discountKt16;

    @Column(name = "name_kt17")
    private String nameKt17;
    @Column(name = "money_kt17")
    private Double moneyKt17;
    @Column(name = "quantity_kt17")
    private Long quantityKt17;
    @Column(name = "price_kt17")
    private Double priceKt17;
    @Column(name = "discount_kt17")
    private Double discountKt17;

    @Column(name = "name_kt18")
    private String nameKt18;
    @Column(name = "money_kt18")
    private Double moneyKt18;
    @Column(name = "quantity_kt18")
    private Long quantityKt18;
    @Column(name = "price_kt18")
    private Double priceKt18;
    @Column(name = "discount_kt18")
    private Double discountKt18;

    @Column(name = "name_kt19")
    private String nameKt19;
    @Column(name = "money_kt19")
    private Double moneyKt19;
    @Column(name = "quantity_kt19")
    private Long quantityKt19;
    @Column(name = "price_kt19")
    private Double priceKt19;
    @Column(name = "discount_kt19")
    private Double discountKt19;

    @Column(name = "name_kt20")
    private String nameKt20;
    @Column(name = "money_kt20")
    private Double moneyKt20;
    @Column(name = "quantity_kt20")
    private Long quantityKt20;
    @Column(name = "price_kt20")
    private Double priceKt20;
    @Column(name = "discount_kt20")
    private Double discountKt20;

    @Column(name = "sum_money")
    private Double sumMoney;

    @Column(name = "collected_money")
    private Double collectedMoney;

    @Column(name = "cash_money")
    private Double cashMoney;

    @Column(name = "transfer_money")
    private Double transferMoney;

    @Column(name = "after_money")
    private Double afterMoney;

    @Column(name = "status")
    private String status;

    @Column(name = "parent_unread", columnDefinition = "bit default 0")
    private Boolean parentUnread;

    @Column(name = "note_excel1", length = 1000)
    private String noteExcel1;

    @Column(name = "note_excel2", length = 1000)
    private String noteExcel2;

    @Column(name = "note_excel3", length = 1000)
    private String noteExcel3;

}
