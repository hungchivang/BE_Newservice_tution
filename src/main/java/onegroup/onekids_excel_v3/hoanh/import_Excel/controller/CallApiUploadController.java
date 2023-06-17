package onegroup.onekids_excel_v3.hoanh.import_Excel.controller;

import com.example.onekids_project.import_Excel.ResponseBeforeUpload;
import com.example.onekids_project.import_Excel.service.CallApiUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController

@RequestMapping("/web/tuition-fees")
public class CallApiUploadController {


    @Autowired
    CallApiUploadService callApiUploadService;


    @PostMapping("/callReadDataExcel")
    public List<ResponseBeforeUpload> uploadAndFillExcelFile(@RequestParam("file") MultipartFile file, @RequestParam("collectionTurn") int collectionTurn, @RequestParam("descriptionTurn") String descriptionTurn) throws IOException {
        System.out.println("Đã nhận được api và gọi cổng service khác");
        return callApiUploadService.readDataFromExcel(file, collectionTurn, descriptionTurn);

    }



    @PostMapping("/hoanh")
    public void hoanh() {
        System.out.println("Đang xem authen");
        callApiUploadService.saveDataFromExcelToDB();
    }



}
