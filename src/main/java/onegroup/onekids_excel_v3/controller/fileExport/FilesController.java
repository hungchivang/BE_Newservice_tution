package onegroup.onekids_excel_v3.controller.fileExport;


import onegroup.onekids_excel_v3.dto.FileInfo;
import onegroup.onekids_excel_v3.dto.ResponseMessage;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.StatusExcel;
import onegroup.onekids_excel_v3.repository.fileStorage.FilesStorageService;
import onegroup.onekids_excel_v3.service.FileExport;
import onegroup.onekids_excel_v3.service.kidsService.KidExcelService;
import onegroup.onekids_excel_v3.service.statusExcel.StatusExcelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static onegroup.onekids_excel_v3.common.AppConstant.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/testExcel")
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @Autowired
    KidExcelService kidExcelService;

    @Autowired
    StatusExcelImpl statusExcelImpl;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/users/export/excel/{idSchool}/{guiId}/{month}/{year}")
    @ResponseBody
    public ResponseEntity<Resource> exportToExcel(HttpServletResponse response, @PathVariable long idSchool, @PathVariable String guiId, @PathVariable int month, @PathVariable int year) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());


        Path source = Paths.get("C:\\Users\\ADMIN\\Desktop\\OneKids\\Code-BackEnd\\Main\\BE_Newservice_tution\\src\\main\\java\\onegroup\\onekids_excel_v3\\uploadExcel\\Template Example.xlsx");
        Path newDir = Paths.get("C:\\Users\\ADMIN\\Desktop\\OneKids\\Code-BackEnd\\Main\\BE_Newservice_tution\\src\\main\\java\\onegroup\\onekids_excel_v3\\uploadExcel\\");

        Files.createDirectories(newDir);
        Files.move(source, newDir.resolve(source.getFileName()),
                StandardCopyOption.REPLACE_EXISTING);

        List<Kids> kidsList = kidExcelService.findAllByIdSchool(idSchool);
        FileExport fileExport = new FileExport(kidsList);

        StatusExcel statusExcel1 = statusExcelImpl.findByGuiId(guiId);

        if (statusExcel1 == null) {
            StatusExcel statusExcel2 = new StatusExcel(guiId, EXPORT_EXCEL_PROCESSING, "ListKids " + currentDateTime + ".xlsx", LocalDateTime.now());
            statusExcelImpl.save(statusExcel2);

            String fileName = statusExcel2.getFileName();
            String pathFile = "C:\\Users\\ADMIN\\Desktop\\OneKids\\Code-BackEnd\\Main\\BE_Newservice_tution\\src\\main\\java\\onegroup\\onekids_excel_v3\\uploadExcel\\" + fileName;

            fileExport.writeHeaderLine(month, year);
            fileExport.writeDataLines();

            try {
                FileOutputStream outputStream = new FileOutputStream(pathFile);
                fileExport.workbook.write(outputStream);
                statusExcel2.setStatus(EXPORT_EXCEL_COMPLETE);
                statusExcelImpl.save(statusExcel2);
                fileExport.workbook.close();
                outputStream.close();
            } catch (IOException ex) {
                statusExcel2.setStatus(EXPORT_EXCEL_FAIL);
                statusExcelImpl.save(statusExcel2);
                fileExport.workbook.close();
                ex.printStackTrace();
            }

            Resource file = storageService.load(statusExcel2.getFileName());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } else {
            String fileName = statusExcel1.getFileName();
            String pathFile = "C:\\Users\\ADMIN\\Desktop\\OneKids\\Code-BackEnd\\Main\\BE_Newservice_tution\\src\\main\\java\\onegroup\\onekids_excel_v3\\uploadExcel\\" + fileName;

            fileExport.writeHeaderLine(month, year);
            fileExport.writeDataLines();

            try {
                FileOutputStream outputStream = new FileOutputStream(pathFile);
                fileExport.workbook.write(outputStream);
                statusExcel1.setStatus(EXPORT_EXCEL_COMPLETE);
                statusExcelImpl.save(statusExcel1);
                fileExport.workbook.close();
                outputStream.close();
            } catch (IOException ex) {
                statusExcel1.setStatus(EXPORT_EXCEL_FAIL);
                statusExcelImpl.save(statusExcel1);
                fileExport.workbook.close();
                ex.printStackTrace();
            }
            Resource file = storageService.load(statusExcel1.getFileName());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }
    }


    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/user/{idSchool}")
    public ResponseEntity<List<Kids>> getAllKids(@PathVariable long idSchool) {
        return new ResponseEntity<>(kidExcelService.findAllByIdSchool(idSchool), HttpStatus.OK);
    }


}
