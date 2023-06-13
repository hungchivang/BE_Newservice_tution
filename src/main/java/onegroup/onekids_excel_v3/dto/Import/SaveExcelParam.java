package onegroup.onekids_excel_v3.dto.Import;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveExcelParam {

    private String kidCode;
    private int month;
    private boolean statusSaveAttendance;
    private boolean statusSaveMoney;


}
