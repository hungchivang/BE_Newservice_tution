package onegroup.onekids_excel_v3.controller.Import;

import onegroup.onekids_excel_v3.dto.Import.ResponseBeforeUpload;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
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
import java.util.Date;

@RestController
public class UploadController {

    @Autowired
    KidsServiceImpl kidsServiceImpl;

    @PostMapping("/importExcel")
    public ResponseBeforeUpload uploadAndFillDB(@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("Đã nhận bàn giao công việc và đang ghi vào DB");


        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowNum = 1;
            for (Row row : sheet) {
                // Bỏ qua hàng đầu tiên (có chỉ số 0)
                if (rowNum == 1 && rowNum == 4) {
                    rowNum++;
                    continue;
                }
                if (rowNum == 2) {
                    String nameSchool = row.getCell(1).getStringCellValue();
                    rowNum++;
                    continue;
                }
                if (rowNum == 3) {
                    int month = (int) row.getCell(1).getNumericCellValue();
                    rowNum++;
                    continue;
                }
                if (rowNum == 5) {
                    String nameKt1 = row.getCell(18).getStringCellValue();
                    String nameKt2 = row.getCell(19).getStringCellValue();
                    String nameKt3 = row.getCell(20).getStringCellValue();
                    String nameKt4 = row.getCell(21).getStringCellValue();
                    String nameKt5 = row.getCell(22).getStringCellValue();
                    String nameKt6 = row.getCell(23).getStringCellValue();
                    String nameKt7 = row.getCell(24).getStringCellValue();
                    String nameKt8 = row.getCell(25).getStringCellValue();
                    String nameKt9 = row.getCell(26).getStringCellValue();
                    String nameKt10 = row.getCell(27).getStringCellValue();
                    String nameKt11 = row.getCell(28).getStringCellValue();
                    String nameKt12 = row.getCell(29).getStringCellValue();
                    String nameKt13 = row.getCell(30).getStringCellValue();
                    String nameKt14 = row.getCell(31).getStringCellValue();
                    String nameKt15 = row.getCell(32).getStringCellValue();
                    String nameKt16 = row.getCell(33).getStringCellValue();
                    String nameKt17 = row.getCell(34).getStringCellValue();
                    String nameKt18 = row.getCell(35).getStringCellValue();
                    String nameKt19 = row.getCell(36).getStringCellValue();
                    String nameKt20 = row.getCell(37).getStringCellValue();
                    rowNum++;
                    continue;


                }
//                Thông tin học sinh

                String kidCode = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                Date birthday = row.getCell(3).getDateCellValue();
                String parentPhone = row.getCell(4).getStringCellValue();
                String nickName = row.getCell(5).getStringCellValue();
                String nameClass = row.getCell(6).getStringCellValue();
                String nameGrade = row.getCell(7).getStringCellValue();

//                Điểm danh học sinh
                long arriveT2t6 = (long) row.getCell(8).getNumericCellValue();
                long arriveT7 = (long) row.getCell(9).getNumericCellValue();
                long arriveCn = (long) row.getCell(10).getNumericCellValue();
                long absentCpT2t6 = (long) row.getCell(11).getNumericCellValue();
                long absentKpT2t6 = (long) row.getCell(12).getNumericCellValue();
                long absentCpT7 = (long) row.getCell(13).getNumericCellValue();
                long absentKpT7 = (long) row.getCell(14).getNumericCellValue();
                long leaveLater = (long) row.getCell(15).getNumericCellValue();
                long quantityDate = (long) row.getCell(16).getNumericCellValue();
                double beforeMoney = row.getCell(17).getNumericCellValue();

//                Khoản thu
                double moneyKt1 = row.getCell(18).getNumericCellValue();
                double moneyKt2 = row.getCell(19).getNumericCellValue();
                double moneyKt3 = row.getCell(20).getNumericCellValue();
                double moneyKt4 = row.getCell(21).getNumericCellValue();
                double moneyKt5 = row.getCell(22).getNumericCellValue();
                double moneyKt6 = row.getCell(23).getNumericCellValue();
                double moneyKt7 = row.getCell(24).getNumericCellValue();
                double moneyKt8 = row.getCell(25).getNumericCellValue();
                double moneyKt9 = row.getCell(26).getNumericCellValue();
                double moneyKt10 = row.getCell(27).getNumericCellValue();
                double moneyKt11 = row.getCell(28).getNumericCellValue();
                double moneyKt12 = row.getCell(29).getNumericCellValue();
                double moneyKt13 = row.getCell(30).getNumericCellValue();
                double moneyKt14 = row.getCell(31).getNumericCellValue();
                double moneyKt15 = row.getCell(32).getNumericCellValue();
                double moneyKt16 = row.getCell(33).getNumericCellValue();
                double moneyKt17 = row.getCell(34).getNumericCellValue();
                double moneyKt18 = row.getCell(35).getNumericCellValue();
                double moneyKt19 = row.getCell(36).getNumericCellValue();
                double moneyKt20 = row.getCell(37).getNumericCellValue();

//                Tổng tiền, tiền trả

                double sumMoney = row.getCell(38).getNumericCellValue();
                double collectedMoney = row.getCell(39).getNumericCellValue();
                double cashMoney = row.getCell(40).getNumericCellValue();
                double transferMoney = row.getCell(41).getNumericCellValue();
                double afterMoney = row.getCell(42).getNumericCellValue();
                String status = row.getCell(43).getStringCellValue();
                String noteExcel1 = row.getCell(44).getStringCellValue();
                String noteExcel2 = row.getCell(45).getStringCellValue();
                String noteExcel3 = row.getCell(46).getStringCellValue();


                ResponseBeforeUpload response = new ResponseBeforeUpload();
                response.setKidCode(kidCode);
                response.setName(name);
                response.setNameClass(nameClass);

                Kids kid = kidsServiceImpl.findKidByKidCode(kidCode);
                if (kid == null) {
                    response.setNotifyKidCode("wrong");
                    return response;
                } else {
                    response.setNotifyKidCode("correct");

                    String code = kid.getKidCode();

                    if (kid.getFullName().equals(name)
                            && kid.getBirthDay().equals(birthday)
                            && kid.getMotherPhone().equals()
                            && kid.getBirthDay().equals(birthday)
                            && kid.getBirthDay().equals(birthday)) {

                    }


                }


//
//                Student student = studentServiceImpl.findStudentByCode(code);
//
//                if (student == null) {
//                    student = new Student(code, name, age);
//                    studentServiceImpl.create(student);
//                } else {
//                    student.setCode(code);
//                    student.setName(name);
//                    student.setAge(age);
//                    studentServiceImpl.edit(student);
//                }
//                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
