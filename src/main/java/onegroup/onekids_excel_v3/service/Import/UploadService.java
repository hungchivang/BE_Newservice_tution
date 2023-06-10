package onegroup.onekids_excel_v3.service.Import;

import onegroup.onekids_excel_v3.dto.Import.DataExcel;
import onegroup.onekids_excel_v3.dto.Import.OrderKidExcelDTO;
import onegroup.onekids_excel_v3.dto.Import.ResponseBeforeUpload;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.repository.Import.ClassRepo;
import onegroup.onekids_excel_v3.repository.Import.GradeRepo;
import onegroup.onekids_excel_v3.service.Import.serviceimpl.KidsServiceImpl;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadService {


    @Autowired
    ClassRepo classRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    KidsServiceImpl kidsServiceImpl;


    List<DataExcel> dataExcels = new ArrayList<>();

    public List<DataExcel> loadExcelToDataExcel(MultipartFile file) throws IOException {

        DataExcel dataExcel = new DataExcel();


        int month = 0;

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);



            for (Row row : sheet) {

                int rowNum = row.getRowNum();
                // Bỏ qua hàng đầu tiên (có chỉ số 0)
                if (rowNum == 0 && rowNum == 3) {

                    continue;
                }
                if (rowNum == 1) {


                    String nameSchool = row.getCell(1).getStringCellValue();
                    dataExcel.setNameSchool(nameSchool);

                    System.out.println("Đây là tên trường............................ " + nameSchool);

                    continue;
                }
                if (rowNum == 2) {

                    month = (int) row.getCell(1).getNumericCellValue();
                    dataExcel.setMonth((long) month);

                    System.out.println("Đây là tháng.............................  " + month);


                    System.out.println(month);

                    continue;
                }
                if (rowNum == 4) {

                    String nameKt1 = row.getCell(18).getStringCellValue();
                    System.out.println("Tên khoản thu 1 là........................:" + nameKt1);
                    String nameKt2 = row.getCell(19).getStringCellValue();

                    System.out.println("Tên khoản thu 2 là..................:" + nameKt2);

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

                    dataExcel.setNameKt1(nameKt1);
                    dataExcel.setNameKt2(nameKt2);
                    dataExcel.setNameKt3(nameKt3);
                    dataExcel.setNameKt4(nameKt4);
                    dataExcel.setNameKt5(nameKt5);
                    dataExcel.setNameKt6(nameKt6);
                    dataExcel.setNameKt7(nameKt7);
                    dataExcel.setNameKt8(nameKt8);
                    dataExcel.setNameKt9(nameKt9);
                    dataExcel.setNameKt10(nameKt10);
                    dataExcel.setNameKt11(nameKt11);
                    dataExcel.setNameKt12(nameKt12);
                    dataExcel.setNameKt13(nameKt13);
                    dataExcel.setNameKt14(nameKt14);
                    dataExcel.setNameKt15(nameKt15);
                    dataExcel.setNameKt16(nameKt16);
                    dataExcel.setNameKt17(nameKt17);
                    dataExcel.setNameKt18(nameKt18);
                    dataExcel.setNameKt19(nameKt19);
                    dataExcel.setNameKt20(nameKt20);

                    continue;

                }

                if(rowNum>4){


//                Thông tin học sinh

                    String kidCode = row.getCell(1).getStringCellValue();
                    System.out.println(kidCode);

                    System.out.println("Đây là code.................. " + kidCode);
                    String name = row.getCell(2).getStringCellValue();
                    System.out.println("Đây là tên:........................" + name);


                    String birthday = row.getCell(3).getStringCellValue();

                    System.out.println("Đây là BirthDay.............................." + birthday);
                    System.out.println(birthday);
//                LocalDate localDateBirthday = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


                    String parentPhone = row.getCell(4).getStringCellValue();
                    System.out.println(parentPhone);


                    String nickName = row.getCell(5).getStringCellValue();
                    System.out.println(nickName);

                    String nameClass = row.getCell(6).getStringCellValue();
                    System.out.println(nameClass);
                    String nameGrade = row.getCell(7).getStringCellValue();
                    System.out.println(nameGrade);

//                Điểm danh học sinh
                    long arriveT2t6 = (long) row.getCell(8).getNumericCellValue();

                    System.out.println("Đây là số ngày t2-t6:..............." + arriveT2t6);

                    long arriveT7 = (long) row.getCell(9).getNumericCellValue();
                    System.out.println(arriveT7);
                    long arriveCn = (long) row.getCell(10).getNumericCellValue();
                    System.out.println(arriveCn);
                    long absentCpT2t6 = (long) row.getCell(11).getNumericCellValue();

                    long absentKpT2t6 = (long) row.getCell(12).getNumericCellValue();
                    long absentCpT7 = (long) row.getCell(13).getNumericCellValue();
                    long absentKpT7 = (long) row.getCell(14).getNumericCellValue();
                    long leaveLater = (long) row.getCell(15).getNumericCellValue();
                    System.out.println(leaveLater);
                    long quantityDate = (long) row.getCell(16).getNumericCellValue();
                    System.out.println("DDaay laf tong ngayf.............."+quantityDate);


                    if (row.getCell(17).getCellType() == CellType.BLANK) {
                        row.getCell(17).setCellValue(0);
                    }

//                    CellType cellType = row.getCell(17).getCellType();
//                    System.out.println(cellType);

                    double beforeMoney = row.getCell(17).getNumericCellValue();
                    System.out.println("Đây là tiền còn lại ..................."+beforeMoney);

//                Khoản thu

                    double moneyKt1 = row.getCell(18).getNumericCellValue();
                    System.out.println(moneyKt1);

                    double moneyKt2 = row.getCell(19).getNumericCellValue();

                    double moneyKt3 = row.getCell(20).getNumericCellValue();



                    double moneyKt4 = row.getCell(21).getNumericCellValue();
                    double moneyKt5 = row.getCell(22).getNumericCellValue();
                    double moneyKt6 = row.getCell(23).getNumericCellValue();
                    double moneyKt7 = row.getCell(24).getNumericCellValue();
                    System.out.println(moneyKt7);

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
                    System.out.println("đÃ CHẠY ĐẾN ĐÂY");

//                Tổng tiền, tiền trả

                    double sumMoney = row.getCell(38).getNumericCellValue();
                    double collectedMoney = row.getCell(39).getNumericCellValue();
                    double cashMoney = row.getCell(40).getNumericCellValue();
                    double transferMoney = row.getCell(41).getNumericCellValue();
                    double afterMoney = row.getCell(42).getNumericCellValue();

                    System.out.println("đÃ CHẠY ĐẾN ĐÂY");



                    String status = row.getCell(43).getStringCellValue();
                    String noteExcel1 = row.getCell(44).getStringCellValue();
                    System.out.println(noteExcel1);
                    String noteExcel2 = row.getCell(45).getStringCellValue();
                    String noteExcel3 = row.getCell(46).getStringCellValue();


                    dataExcel.setKidCode(kidCode);

                    dataExcel.setNameKid(name);

                    dataExcel.setBirthday(birthday);
                    dataExcel.setParentPhone(parentPhone);
                    dataExcel.setNickName(nickName);
                    dataExcel.setNameClass(nameClass);
                    dataExcel.setNameGrade(nameGrade);
                    dataExcel.setArriveT2t6(arriveT2t6);
                    dataExcel.setArriveT7(arriveT7);
                    dataExcel.setArriveCn(arriveCn);
                    dataExcel.setAbsentCpT2t6(absentCpT2t6);
                    dataExcel.setAbsentKpT2t6(absentKpT2t6);
                    dataExcel.setAbsentCpT7(absentCpT7);
                    dataExcel.setAbsentKpT7(absentKpT7);
                    dataExcel.setLeaveLater(leaveLater);
                    dataExcel.setQuantityDate(quantityDate);
                    dataExcel.setBeforeMoney(beforeMoney);
                    dataExcel.setMoneyKt1(moneyKt1);
                    dataExcel.setMoneyKt2(moneyKt2);
                    dataExcel.setMoneyKt3(moneyKt3);
                    dataExcel.setMoneyKt4(moneyKt4);
                    dataExcel.setMoneyKt5(moneyKt5);

                    dataExcel.setMoneyKt6(moneyKt6);
                    dataExcel.setMoneyKt7(moneyKt7);
                    dataExcel.setMoneyKt8(moneyKt8);
                    dataExcel.setMoneyKt9(moneyKt9);
                    dataExcel.setMoneyKt10(moneyKt10);
                    dataExcel.setMoneyKt11(moneyKt11);
                    dataExcel.setMoneyKt12(moneyKt12);
                    dataExcel.setMoneyKt13(moneyKt13);
                    dataExcel.setMoneyKt14(moneyKt14);
                    dataExcel.setMoneyKt15(moneyKt15);
                    dataExcel.setMoneyKt16(moneyKt16);
                    dataExcel.setMoneyKt17(moneyKt17);
                    dataExcel.setMoneyKt18(moneyKt18);
                    dataExcel.setMoneyKt19(moneyKt19);
                    dataExcel.setMoneyKt20(moneyKt20);

                    dataExcel.setSumMoney(sumMoney);

                    dataExcel.setCollectedMoney(collectedMoney);
                    dataExcel.setCashMoney(cashMoney);
                    dataExcel.setTransferMoney(transferMoney);
                    dataExcel.setAfterMoney(afterMoney);
                    dataExcel.setStatus(status);
                    dataExcel.setNoteExcel1(noteExcel1);
                    dataExcel.setNoteExcel2(noteExcel2);
                    dataExcel.setNoteExcel3(noteExcel3);
                    System.out.println("Đây là một đối tượng DataExcel");
                    System.out.println(dataExcel);
                }



                dataExcels.add(dataExcel);

            }

            System.out.println(dataExcels);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataExcels;
    }


    public List<ResponseBeforeUpload> beforeUpload(@RequestParam("file") MultipartFile file) throws IOException {

        List<ResponseBeforeUpload> responseBeforeUploads = new ArrayList<>();


        System.out.println("Đã nhận bàn giao công việc và đang ghi vào DB");


        int month = 0;

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

                    month = (int) row.getCell(1).getNumericCellValue();
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
                    responseBeforeUploads.add(response);
                    rowNum++;


                } else {
                    response.setNotifyKidCode("correct");

                    String code = kid.getKidCode();

                    if (kid.getFullName().equals(name)
                            && kid.getBirthDay().equals(birthday)
                            && kid.getMotherPhone().equals(parentPhone) || kid.getFatherPhone().equals(parentPhone)
                            && kid.getNickName().equals(nickName)
                            && kid.getMaClass().getClassName().equals(nameClass)
                            && gradeRepo.findById(kid.getIdGrade()).equals(nameGrade)) {

                        response.setNotifyInfo("correct");

//                        STT	Mã học sinh	Họ và tên	Ngày sinh	Số điện thoại	Biệt danh	Lớp	Khối/Nhóm

                    } else {
                        response.setNotifyInfo("wrong");
                    }


                    switch (month) {
                        case 1:


                            // Làm gì đó tại đây ...
                            break;
                        case 2:
                            // Làm gì đó tại đây ...
                            break;
                        default:
                            // Làm gì đó tại đây ...
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

        return responseBeforeUploads;
    }


}
