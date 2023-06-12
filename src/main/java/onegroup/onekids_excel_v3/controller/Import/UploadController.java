package onegroup.onekids_excel_v3.controller.Import;

import onegroup.onekids_excel_v3.dto.Import.DataExcel;
import onegroup.onekids_excel_v3.dto.Import.ResponseBeforeUpload;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.repository.Import.ClassRepo;
import onegroup.onekids_excel_v3.repository.Import.GradeRepo;
import onegroup.onekids_excel_v3.service.Import.UploadService;
import onegroup.onekids_excel_v3.service.Import.serviceimpl.KidsServiceImpl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

//    @PostMapping("/uploadExcel")
//    public List<ResponseBeforeUpload> beforeUpload(@RequestParam("file") MultipartFile file) throws IOException {
//
//        return uploadService.loadExcelToDataExcel(file);
//
//    }


    @PostMapping("/uploadExcel")
    public List<DataExcel> beforeUpload(@RequestParam("file") MultipartFile file) throws IOException {

        return uploadService.loadExcel(file);

    }




}
