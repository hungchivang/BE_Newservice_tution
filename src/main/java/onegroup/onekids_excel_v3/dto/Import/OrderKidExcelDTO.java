package onegroup.onekids_excel_v3.dto.Import;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onegroup.onekids_excel_v3.common.AppConstant;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderKidExcelDTO {
    private Long id;
    private Long idCreated;
    // tên người tạo, người dùng tự thêm vào
    private String createdBy;
    // thời gian tạo, lấy tự động
    private LocalDateTime createdDate;
    // id người sửa. lấy tự động
    private Long idModified;
    // 1 là hiện thị ra, 0 là ko hiện thị ra
    private boolean delActive = AppConstant.APP_TRUE;
    private Boolean orderHidden;
    private String kidCode;
    private String orderKidCode;
    private String category;
    private int collectionTurn;
    private String descriptionTurn;
    private Long arriveT2t6;
    private Long arriveT7;
    private Long arriveCn;
    private Long absentCpT2t6;
    private Long absentKpT2t6;
    private Long absentCpT7;
    private Long absentKpT7;
    private Long leaveLater;
    private Long quantityDate;
    private Double beforeMoney;


    private String nameKt1;
    private Double moneyKt1;
    private Long quantityKt1;
    private Double priceKt1;
    private Double discountKt1;

    private String nameKt2;
    private Double moneyKt2;
    private Long quantityKt2;
    private Double priceKt2;
    private Double discountKt2;

    private String nameKt3;
    private Double moneyKt3;
    private Long quantityKt3;
    private Double priceKt3;
    private Double discountKt3;

    private String nameKt4;
    private Double moneyKt4;
    private Long quantityKt4;
    private Double priceKt4;
    private Double discountKt4;

    private String nameKt5;
    private Double moneyKt5;
    private Long quantityKt5;
    private Double priceKt5;
    private Double discountKt5;

    private String nameKt6;
    private Double moneyKt6;
    private Long quantityKt6;
    private Double priceKt6;
    private Double discountKt6;

    private String nameKt7;
    private Double moneyKt7;
    private Long quantityKt7;
    private Double priceKt7;
    private Double discountKt7;

    private String nameKt8;
    private Double moneyKt8;
    private Long quantityKt8;
    private Double priceKt8;
    private Double discountKt8;

    private String nameKt9;
    private Double moneyKt9;
    private Long quantityKt9;
    private Double priceKt9;
    private Double discountKt9;

    private String nameKt10;
    private Double moneyKt10;
    private Long quantityKt10;
    private Double priceKt10;
    private Double discountKt10;

    private String nameKt11;
    private Double moneyKt11;
    private Long quantityKt11;
    private Double priceKt11;
    private Double discountKt11;

    private String nameKt12;
    private Double moneyKt12;
    private Long quantityKt12;
    private Double priceKt12;
    private Double discountKt12;

    private String nameKt13;
    private Double moneyKt13;
    private Long quantityKt13;
    private Double priceKt13;
    private Double discountKt13;

    private String nameKt14;
    private Double moneyKt14;
    private Long quantityKt14;
    private Double priceKt14;
    private Double discountKt14;

    private String nameKt15;
    private Double moneyKt15;
    private Long quantityKt15;
    private Double priceKt15;
    private Double discountKt15;

    private String nameKt16;
    private Double moneyKt16;
    private Long quantityKt16;
    private Double priceKt16;
    private Double discountKt16;

    private String nameKt17;
    private Double moneyKt17;
    private Long quantityKt17;
    private Double priceKt17;
    private Double discountKt17;

    private String nameKt18;
    private Double moneyKt18;
    private Long quantityKt18;
    private Double priceKt18;
    private Double discountKt18;

    private String nameKt19;
    private Double moneyKt19;
    private Long quantityKt19;
    private Double priceKt19;
    private Double discountKt19;

    private String nameKt20;
    private Double moneyKt20;
    private Long quantityKt20;
    private Double priceKt20;
    private Double discountKt20;

    private Double sumMoney;

    private Double collectedMoney;

    private Double cashMoney;

    private Double transferMoney;

    private Double afterMoney;

    private String status;

    private Boolean parentUnread;

    private String noteExcel1;

    private String noteExcel2;

    private String noteExcel3;


}
