package onegroup.onekids_excel_v3.controller.Import;

import onegroup.onekids_excel_v3.dto.Import.ResponseBeforeUpload;
import onegroup.onekids_excel_v3.dto.Import.SaveExcelParam;
import onegroup.onekids_excel_v3.repository.Import.ClassRepo;
import onegroup.onekids_excel_v3.repository.Import.GradeRepo;
import onegroup.onekids_excel_v3.service.Import.UploadService;
import onegroup.onekids_excel_v3.service.Import.serviceimpl.KidsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

@RestController
public class UploadController {


    @Autowired
    ClassRepo classRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    KidsServiceImpl kidsServiceImpl;

    @Autowired
    UploadService uploadService;

    @PostMapping("/uploadExcel")
    public List<ResponseBeforeUpload> beforeUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadService.loadExcelToDataExcel(file);
    }

    @PostMapping("/saveExcelToDB")
    public void beforeUpload(@RequestBody SaveExcelParam saveExcelParam) {
        uploadService.saveDataFromExcelToDB(saveExcelParam);
    }





}
