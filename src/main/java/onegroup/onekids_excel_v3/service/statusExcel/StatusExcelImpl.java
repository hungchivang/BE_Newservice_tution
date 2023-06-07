package onegroup.onekids_excel_v3.service.statusExcel;

import onegroup.onekids_excel_v3.entity.excel.StatusExcel;
import onegroup.onekids_excel_v3.repository.statusExcel.StatusExcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusExcelImpl {

    @Autowired
    StatusExcelRepo statusExcelRepo;

    public void save(StatusExcel statusExcel) {
        statusExcelRepo.save(statusExcel);
    }

    public StatusExcel findByGuiId(String guiId){
        return statusExcelRepo.findByGuiId(guiId);
    }
}
