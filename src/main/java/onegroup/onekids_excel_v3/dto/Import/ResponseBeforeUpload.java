package onegroup.onekids_excel_v3.dto.Import;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBeforeUpload {

    private String notifyKidCode;
    private String notifyInfo;
    private String notifyAttendance;
    private String notifyMoney;
    private String kidCode;
    private String name;
    private String nameClass;

//    private List<Integer> collectionTurn;

    public ResponseBeforeUpload() {
    }

    public ResponseBeforeUpload(String notifyKidCode, String notifyInfo, String notifyAttendance, String notifyMoney, String kidCode, String name, String nameClass) {
        this.notifyKidCode = notifyKidCode;
        this.notifyInfo = notifyInfo;
        this.notifyAttendance = notifyAttendance;
        this.notifyMoney = notifyMoney;
        this.kidCode = kidCode;
        this.name = name;
        this.nameClass = nameClass;
    }
}
