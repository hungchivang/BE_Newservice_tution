package onegroup.onekids_excel_v3.dto.Import;

import lombok.Data;
import onegroup.onekids_excel_v3.common.AppConstant;

import java.time.LocalDateTime;
@Data
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

    public OrderKidExcelDTO() {
    }

    public OrderKidExcelDTO(Long id, Long idCreated, String createdBy, LocalDateTime createdDate, Long idModified, boolean delActive, Boolean orderHidden, String kidCode, String orderKidCode, String category, Long arriveT2t6, Long arriveT7, Long arriveCn, Long absentCpT2t6, Long absentKpT2t6, Long absentCpT7, Long absentKpT7, Long leaveLater, Long quantityDate, Double beforeMoney, String nameKt1, Double moneyKt1, Long quantityKt1, Double priceKt1, Double discountKt1, String nameKt2, Double moneyKt2, Long quantityKt2, Double priceKt2, Double discountKt2, String nameKt3, Double moneyKt3, Long quantityKt3, Double priceKt3, Double discountKt3, String nameKt4, Double moneyKt4, Long quantityKt4, Double priceKt4, Double discountKt4, String nameKt5, Double moneyKt5, Long quantityKt5, Double priceKt5, Double discountKt5, String nameKt6, Double moneyKt6, Long quantityKt6, Double priceKt6, Double discountKt6, String nameKt7, Double moneyKt7, Long quantityKt7, Double priceKt7, Double discountKt7, String nameKt8, Double moneyKt8, Long quantityKt8, Double priceKt8, Double discountKt8, String nameKt9, Double moneyKt9, Long quantityKt9, Double priceKt9, Double discountKt9, String nameKt10, Double moneyKt10, Long quantityKt10, Double priceKt10, Double discountKt10, String nameKt11, Double moneyKt11, Long quantityKt11, Double priceKt11, Double discountKt11, String nameKt12, Double moneyKt12, Long quantityKt12, Double priceKt12, Double discountKt12, String nameKt13, Double moneyKt13, Long quantityKt13, Double priceKt13, Double discountKt13, String nameKt14, Double moneyKt14, Long quantityKt14, Double priceKt14, Double discountKt14, String nameKt15, Double moneyKt15, Long quantityKt15, Double priceKt15, Double discountKt15, String nameKt16, Double moneyKt16, Long quantityKt16, Double priceKt16, Double discountKt16, String nameKt17, Double moneyKt17, Long quantityKt17, Double priceKt17, Double discountKt17, String nameKt18, Double moneyKt18, Long quantityKt18, Double priceKt18, Double discountKt18, String nameKt19, Double moneyKt19, Long quantityKt19, Double priceKt19, Double discountKt19, String nameKt20, Double moneyKt20, Long quantityKt20, Double priceKt20, Double discountKt20, Double sumMoney, Double collectedMoney, Double cashMoney, Double transferMoney, Double afterMoney, String status, Boolean parentUnread, String noteExcel1, String noteExcel2, String noteExcel3) {
        this.id = id;
        this.idCreated = idCreated;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.idModified = idModified;
        this.delActive = delActive;
        this.orderHidden = orderHidden;
        this.kidCode = kidCode;
        this.orderKidCode = orderKidCode;
        this.category = category;
        this.arriveT2t6 = arriveT2t6;
        this.arriveT7 = arriveT7;
        this.arriveCn = arriveCn;
        this.absentCpT2t6 = absentCpT2t6;
        this.absentKpT2t6 = absentKpT2t6;
        this.absentCpT7 = absentCpT7;
        this.absentKpT7 = absentKpT7;
        this.leaveLater = leaveLater;
        this.quantityDate = quantityDate;
        this.beforeMoney = beforeMoney;
        this.nameKt1 = nameKt1;
        this.moneyKt1 = moneyKt1;
        this.quantityKt1 = quantityKt1;
        this.priceKt1 = priceKt1;
        this.discountKt1 = discountKt1;
        this.nameKt2 = nameKt2;
        this.moneyKt2 = moneyKt2;
        this.quantityKt2 = quantityKt2;
        this.priceKt2 = priceKt2;
        this.discountKt2 = discountKt2;
        this.nameKt3 = nameKt3;
        this.moneyKt3 = moneyKt3;
        this.quantityKt3 = quantityKt3;
        this.priceKt3 = priceKt3;
        this.discountKt3 = discountKt3;
        this.nameKt4 = nameKt4;
        this.moneyKt4 = moneyKt4;
        this.quantityKt4 = quantityKt4;
        this.priceKt4 = priceKt4;
        this.discountKt4 = discountKt4;
        this.nameKt5 = nameKt5;
        this.moneyKt5 = moneyKt5;
        this.quantityKt5 = quantityKt5;
        this.priceKt5 = priceKt5;
        this.discountKt5 = discountKt5;
        this.nameKt6 = nameKt6;
        this.moneyKt6 = moneyKt6;
        this.quantityKt6 = quantityKt6;
        this.priceKt6 = priceKt6;
        this.discountKt6 = discountKt6;
        this.nameKt7 = nameKt7;
        this.moneyKt7 = moneyKt7;
        this.quantityKt7 = quantityKt7;
        this.priceKt7 = priceKt7;
        this.discountKt7 = discountKt7;
        this.nameKt8 = nameKt8;
        this.moneyKt8 = moneyKt8;
        this.quantityKt8 = quantityKt8;
        this.priceKt8 = priceKt8;
        this.discountKt8 = discountKt8;
        this.nameKt9 = nameKt9;
        this.moneyKt9 = moneyKt9;
        this.quantityKt9 = quantityKt9;
        this.priceKt9 = priceKt9;
        this.discountKt9 = discountKt9;
        this.nameKt10 = nameKt10;
        this.moneyKt10 = moneyKt10;
        this.quantityKt10 = quantityKt10;
        this.priceKt10 = priceKt10;
        this.discountKt10 = discountKt10;
        this.nameKt11 = nameKt11;
        this.moneyKt11 = moneyKt11;
        this.quantityKt11 = quantityKt11;
        this.priceKt11 = priceKt11;
        this.discountKt11 = discountKt11;
        this.nameKt12 = nameKt12;
        this.moneyKt12 = moneyKt12;
        this.quantityKt12 = quantityKt12;
        this.priceKt12 = priceKt12;
        this.discountKt12 = discountKt12;
        this.nameKt13 = nameKt13;
        this.moneyKt13 = moneyKt13;
        this.quantityKt13 = quantityKt13;
        this.priceKt13 = priceKt13;
        this.discountKt13 = discountKt13;
        this.nameKt14 = nameKt14;
        this.moneyKt14 = moneyKt14;
        this.quantityKt14 = quantityKt14;
        this.priceKt14 = priceKt14;
        this.discountKt14 = discountKt14;
        this.nameKt15 = nameKt15;
        this.moneyKt15 = moneyKt15;
        this.quantityKt15 = quantityKt15;
        this.priceKt15 = priceKt15;
        this.discountKt15 = discountKt15;
        this.nameKt16 = nameKt16;
        this.moneyKt16 = moneyKt16;
        this.quantityKt16 = quantityKt16;
        this.priceKt16 = priceKt16;
        this.discountKt16 = discountKt16;
        this.nameKt17 = nameKt17;
        this.moneyKt17 = moneyKt17;
        this.quantityKt17 = quantityKt17;
        this.priceKt17 = priceKt17;
        this.discountKt17 = discountKt17;
        this.nameKt18 = nameKt18;
        this.moneyKt18 = moneyKt18;
        this.quantityKt18 = quantityKt18;
        this.priceKt18 = priceKt18;
        this.discountKt18 = discountKt18;
        this.nameKt19 = nameKt19;
        this.moneyKt19 = moneyKt19;
        this.quantityKt19 = quantityKt19;
        this.priceKt19 = priceKt19;
        this.discountKt19 = discountKt19;
        this.nameKt20 = nameKt20;
        this.moneyKt20 = moneyKt20;
        this.quantityKt20 = quantityKt20;
        this.priceKt20 = priceKt20;
        this.discountKt20 = discountKt20;
        this.sumMoney = sumMoney;
        this.collectedMoney = collectedMoney;
        this.cashMoney = cashMoney;
        this.transferMoney = transferMoney;
        this.afterMoney = afterMoney;
        this.status = status;
        this.parentUnread = parentUnread;
        this.noteExcel1 = noteExcel1;
        this.noteExcel2 = noteExcel2;
        this.noteExcel3 = noteExcel3;
    }
}
