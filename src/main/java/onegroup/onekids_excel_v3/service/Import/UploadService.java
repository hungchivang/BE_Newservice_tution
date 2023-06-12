package onegroup.onekids_excel_v3.service.Import;

import onegroup.onekids_excel_v3.common.AppConstant;
import onegroup.onekids_excel_v3.dto.Import.DataExcel;
import onegroup.onekids_excel_v3.dto.Import.OrderKidExcelDTO;
import onegroup.onekids_excel_v3.dto.Import.ResponseBeforeUpload;
import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT01;
import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT02;
import onegroup.onekids_excel_v3.entity.excel.TotalKidsArrive;
import onegroup.onekids_excel_v3.repository.Import.*;
import onegroup.onekids_excel_v3.service.Import.serviceimpl.KidsServiceImpl;
import org.apache.poi.ss.usermodel.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UploadService {


    @Autowired
    ClassRepo classRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    TotalKidArriveRepo totalKidArriveRepo;

    @Autowired
    OrderKidExcelT01Repo orderKidExcelT01Repo;

    @Autowired
    OrderKidExcelT02Repo orderKidExcelT02Repo;

    @Autowired
    KidsServiceImpl kidsServiceImpl;

    @Autowired
    ModelMapper modelMapper;


    List<DataExcel> dataExcels = new ArrayList<>();
    List<ResponseBeforeUpload> responseBeforeUploads = new ArrayList<>();

    int month = 0;

//    public List<ResponseBeforeUpload> loadExcelToDataExcel(MultipartFile file) throws IOException {
//
//        DataExcel dataExcel = new DataExcel();
//
//
//        try (InputStream inputStream = file.getInputStream()) {
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            Sheet sheet = workbook.getSheetAt(0);
//
//
//            for (Row row : sheet) {
//
//                int rowNum = row.getRowNum();
//                // Bỏ qua hàng đầu tiên (có chỉ số 0)
//                if (rowNum == 0 && rowNum == 3) {
//
//                    continue;
//                }
//                if (rowNum == 1) {
//                    String nameSchool = row.getCell(1).getStringCellValue();
//                    dataExcel.setNameSchool(nameSchool);
//                    System.out.println("Đây là tên trường............................ " + nameSchool);
//                    continue;
//                }
//                if (rowNum == 2) {
//                    month = (int) row.getCell(1).getNumericCellValue();
//                    dataExcel.setMonth((long) month);
//                    System.out.println("Đây là tháng.............................  " + month);
//                    continue;
//                }
//                if (rowNum == 4) {
//
//                    String nameKt1 = row.getCell(18).getStringCellValue();
//                    System.out.println("Tên khoản thu 1 là........................:" + nameKt1);
//                    String nameKt2 = row.getCell(19).getStringCellValue();
//                    System.out.println("Tên khoản thu 2 là..................:" + nameKt2);
//                    String nameKt3 = row.getCell(20).getStringCellValue();
//                    String nameKt4 = row.getCell(21).getStringCellValue();
//                    String nameKt5 = row.getCell(22).getStringCellValue();
//                    String nameKt6 = row.getCell(23).getStringCellValue();
//                    String nameKt7 = row.getCell(24).getStringCellValue();
//                    String nameKt8 = row.getCell(25).getStringCellValue();
//                    String nameKt9 = row.getCell(26).getStringCellValue();
//                    String nameKt10 = row.getCell(27).getStringCellValue();
//                    String nameKt11 = row.getCell(28).getStringCellValue();
//                    String nameKt12 = row.getCell(29).getStringCellValue();
//                    String nameKt13 = row.getCell(30).getStringCellValue();
//                    String nameKt14 = row.getCell(31).getStringCellValue();
//                    String nameKt15 = row.getCell(32).getStringCellValue();
//                    String nameKt16 = row.getCell(33).getStringCellValue();
//                    String nameKt17 = row.getCell(34).getStringCellValue();
//                    String nameKt18 = row.getCell(35).getStringCellValue();
//                    String nameKt19 = row.getCell(36).getStringCellValue();
//                    String nameKt20 = row.getCell(37).getStringCellValue();
//
//                    dataExcel.setNameKt1(nameKt1);
//                    dataExcel.setNameKt2(nameKt2);
//                    dataExcel.setNameKt3(nameKt3);
//                    dataExcel.setNameKt4(nameKt4);
//                    dataExcel.setNameKt5(nameKt5);
//                    dataExcel.setNameKt6(nameKt6);
//                    dataExcel.setNameKt7(nameKt7);
//                    dataExcel.setNameKt8(nameKt8);
//                    dataExcel.setNameKt9(nameKt9);
//                    dataExcel.setNameKt10(nameKt10);
//                    dataExcel.setNameKt11(nameKt11);
//                    dataExcel.setNameKt12(nameKt12);
//                    dataExcel.setNameKt13(nameKt13);
//                    dataExcel.setNameKt14(nameKt14);
//                    dataExcel.setNameKt15(nameKt15);
//                    dataExcel.setNameKt16(nameKt16);
//                    dataExcel.setNameKt17(nameKt17);
//                    dataExcel.setNameKt18(nameKt18);
//                    dataExcel.setNameKt19(nameKt19);
//                    dataExcel.setNameKt20(nameKt20);
//                    continue;
//                }
//                if (rowNum > 4) {
////                Thông tin học sinh
//
//                    String kidCode = row.getCell(1).getStringCellValue();
//                    System.out.println("Đây là code.................. " + kidCode);
//                    String name = row.getCell(2).getStringCellValue();
//                    System.out.println("Đây là tên:........................" + name);
//                    String birthday = row.getCell(3).getStringCellValue();
//                    System.out.println("Đây là BirthDay.............................." + birthday);
//                    System.out.println(birthday);
//                    String parentPhone = row.getCell(4).getStringCellValue();
//                    String nickName = row.getCell(5).getStringCellValue();
//                    String nameClass = row.getCell(6).getStringCellValue();
//                    String nameGrade = row.getCell(7).getStringCellValue();
//
////                Điểm danh học sinh
//                    long arriveT2t6 = (long) row.getCell(8).getNumericCellValue();
//
//                    System.out.println("Đây là số ngày t2-t6:..............." + arriveT2t6);
//
//                    Long arriveT7 = (long) row.getCell(9).getNumericCellValue();
//                    Long arriveCn = (long) row.getCell(10).getNumericCellValue();
//                    Long absentCpT2t6 = (long) row.getCell(11).getNumericCellValue();
//                    Long absentKpT2t6 = (long) row.getCell(12).getNumericCellValue();
//                    Long absentCpT7 = (long) row.getCell(13).getNumericCellValue();
//                    Long absentKpT7 = (long) row.getCell(14).getNumericCellValue();
//                    Long leaveLater = (long) row.getCell(15).getNumericCellValue();
//                    Long quantityDate = (long) row.getCell(16).getNumericCellValue();
//                    System.out.println("DDaay laf tong ngayf.............." + quantityDate);
//
//
//                    if (row.getCell(17).getCellType() == CellType.BLANK) {
//                        row.getCell(17).setCellValue(0);
//                    }
//                    double beforeMoney = row.getCell(17).getNumericCellValue();
//                    System.out.println("Đây là tiền còn lại ..................." + beforeMoney);
//
//
////                Khoản thu
//
//
//                    if (row.getCell(18).getCellType() == CellType.BLANK) {
//                        row.getCell(18).setCellValue(0);
//                    }
//                    double moneyKt1 = row.getCell(18).getNumericCellValue();
//
//
//                    if (row.getCell(19).getCellType() == CellType.BLANK) {
//                        row.getCell(19).setCellValue(0);
//                    }
//                    double moneyKt2 = row.getCell(19).getNumericCellValue();
//
//
//                    if (row.getCell(20).getCellType() == CellType.BLANK) {
//                        row.getCell(20).setCellValue(0);
//                    }
//                    double moneyKt3 = row.getCell(20).getNumericCellValue();
//
//
//                    if (row.getCell(21).getCellType() == CellType.BLANK) {
//                        row.getCell(21).setCellValue(0);
//                    }
//                    double moneyKt4 = row.getCell(21).getNumericCellValue();
//
//
//                    if (row.getCell(22).getCellType() == CellType.BLANK) {
//                        row.getCell(22).setCellValue(0);
//                    }
//                    double moneyKt5 = row.getCell(22).getNumericCellValue();
//
//
//                    if (row.getCell(23).getCellType() == CellType.BLANK) {
//                        row.getCell(23).setCellValue(0);
//                    }
//                    double moneyKt6 = row.getCell(23).getNumericCellValue();
//
//
//                    if (row.getCell(24).getCellType() == CellType.BLANK) {
//                        row.getCell(24).setCellValue(0);
//                    }
//                    double moneyKt7 = row.getCell(24).getNumericCellValue();
//
//
//                    if (row.getCell(25).getCellType() == CellType.BLANK) {
//                        row.getCell(25).setCellValue(0);
//                    }
//                    double moneyKt8 = row.getCell(25).getNumericCellValue();
//
//
//                    if (row.getCell(26).getCellType() == CellType.BLANK) {
//                        row.getCell(26).setCellValue(0);
//                    }
//                    double moneyKt9 = row.getCell(26).getNumericCellValue();
//
//
//                    if (row.getCell(27).getCellType() == CellType.BLANK) {
//                        row.getCell(27).setCellValue(0);
//                    }
//                    double moneyKt10 = row.getCell(27).getNumericCellValue();
//
//
//                    if (row.getCell(28).getCellType() == CellType.BLANK) {
//                        row.getCell(28).setCellValue(0);
//                    }
//                    double moneyKt11 = row.getCell(28).getNumericCellValue();
//
//
//                    if (row.getCell(29).getCellType() == CellType.BLANK) {
//                        row.getCell(29).setCellValue(0);
//                    }
//                    double moneyKt12 = row.getCell(29).getNumericCellValue();
//
//
//                    if (row.getCell(30).getCellType() == CellType.BLANK) {
//                        row.getCell(30).setCellValue(0);
//                    }
//                    double moneyKt13 = row.getCell(30).getNumericCellValue();
//
//
//                    if (row.getCell(31).getCellType() == CellType.BLANK) {
//                        row.getCell(31).setCellValue(0);
//                    }
//                    double moneyKt14 = row.getCell(31).getNumericCellValue();
//
//
//                    if (row.getCell(32).getCellType() == CellType.BLANK) {
//                        row.getCell(32).setCellValue(0);
//                    }
//                    double moneyKt15 = row.getCell(32).getNumericCellValue();
//
//
//                    if (row.getCell(33).getCellType() == CellType.BLANK) {
//                        row.getCell(33).setCellValue(0);
//                    }
//                    double moneyKt16 = row.getCell(33).getNumericCellValue();
//
//
//                    if (row.getCell(34).getCellType() == CellType.BLANK) {
//                        row.getCell(34).setCellValue(0);
//                    }
//                    double moneyKt17 = row.getCell(34).getNumericCellValue();
//
//
//                    if (row.getCell(35).getCellType() == CellType.BLANK) {
//                        row.getCell(35).setCellValue(0);
//                    }
//                    double moneyKt18 = row.getCell(35).getNumericCellValue();
//
//
//                    if (row.getCell(36).getCellType() == CellType.BLANK) {
//                        row.getCell(36).setCellValue(0);
//                    }
//                    double moneyKt19 = row.getCell(36).getNumericCellValue();
//
//
//                    if (row.getCell(37).getCellType() == CellType.BLANK) {
//                        row.getCell(37).setCellValue(0);
//                    }
//                    double moneyKt20 = row.getCell(37).getNumericCellValue();
//
//
////                Tổng tiền, tiền trả
//                    if (row.getCell(38).getCellType() == CellType.BLANK) {
//                        row.getCell(38).setCellValue(0);
//                    }
//                    double sumMoney = row.getCell(38).getNumericCellValue();
//
//
//                    if (row.getCell(39).getCellType() == CellType.BLANK) {
//                        row.getCell(39).setCellValue(0);
//                    }
//                    double collectedMoney = row.getCell(39).getNumericCellValue();
//
//
//                    if (row.getCell(40).getCellType() == CellType.BLANK) {
//                        row.getCell(40).setCellValue(0);
//                    }
//                    double cashMoney = row.getCell(40).getNumericCellValue();
//
//
//                    if (row.getCell(41).getCellType() == CellType.BLANK) {
//                        row.getCell(41).setCellValue(0);
//                    }
//                    double transferMoney = row.getCell(41).getNumericCellValue();
//
//
//                    if (row.getCell(42).getCellType() == CellType.BLANK) {
//                        row.getCell(42).setCellValue(0);
//                    }
//                    double afterMoney = row.getCell(42).getNumericCellValue();
//
//
//                    String status = row.getCell(43).getStringCellValue();
//                    String noteExcel1 = row.getCell(44).getStringCellValue();
//                    String noteExcel2 = row.getCell(45).getStringCellValue();
//                    String noteExcel3 = row.getCell(46).getStringCellValue();
//
//
//                    dataExcel.setKidCode(kidCode);
//
//                    dataExcel.setNameKid(name);
//
//                    dataExcel.setBirthday(birthday);
//                    dataExcel.setParentPhone(parentPhone);
//                    dataExcel.setNickName(nickName);
//                    dataExcel.setNameClass(nameClass);
//                    dataExcel.setNameGrade(nameGrade);
//                    dataExcel.setArriveT2t6(arriveT2t6);
//                    dataExcel.setArriveT7(arriveT7);
//                    dataExcel.setArriveCn(arriveCn);
//                    dataExcel.setAbsentCpT2t6(absentCpT2t6);
//                    dataExcel.setAbsentKpT2t6(absentKpT2t6);
//                    dataExcel.setAbsentCpT7(absentCpT7);
//                    dataExcel.setAbsentKpT7(absentKpT7);
//                    dataExcel.setLeaveLater(leaveLater);
//                    dataExcel.setQuantityDate(quantityDate);
//                    dataExcel.setBeforeMoney(beforeMoney);
//                    dataExcel.setMoneyKt1(moneyKt1);
//                    dataExcel.setMoneyKt2(moneyKt2);
//                    dataExcel.setMoneyKt3(moneyKt3);
//                    dataExcel.setMoneyKt4(moneyKt4);
//                    dataExcel.setMoneyKt5(moneyKt5);
//                    dataExcel.setMoneyKt6(moneyKt6);
//                    dataExcel.setMoneyKt7(moneyKt7);
//                    dataExcel.setMoneyKt8(moneyKt8);
//                    dataExcel.setMoneyKt9(moneyKt9);
//                    dataExcel.setMoneyKt10(moneyKt10);
//                    dataExcel.setMoneyKt11(moneyKt11);
//                    dataExcel.setMoneyKt12(moneyKt12);
//                    dataExcel.setMoneyKt13(moneyKt13);
//                    dataExcel.setMoneyKt14(moneyKt14);
//                    dataExcel.setMoneyKt15(moneyKt15);
//                    dataExcel.setMoneyKt16(moneyKt16);
//                    dataExcel.setMoneyKt17(moneyKt17);
//                    dataExcel.setMoneyKt18(moneyKt18);
//                    dataExcel.setMoneyKt19(moneyKt19);
//                    dataExcel.setMoneyKt20(moneyKt20);
//                    dataExcel.setSumMoney(sumMoney);
//                    dataExcel.setCollectedMoney(collectedMoney);
//                    dataExcel.setCashMoney(cashMoney);
//                    dataExcel.setTransferMoney(transferMoney);
//                    dataExcel.setAfterMoney(afterMoney);
//                    dataExcel.setStatus(status);
//                    dataExcel.setNoteExcel1(noteExcel1);
//                    dataExcel.setNoteExcel2(noteExcel2);
//                    dataExcel.setNoteExcel3(noteExcel3);
//                    System.out.println("Đây là một đối tượng DataExcel");
//                    System.out.println(dataExcel);
//                }
//                dataExcels.add(dataExcel);
//            }
//            System.out.println(dataExcels.size());
//            System.out.println(dataExcels);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return checkDataExcel(dataExcels);
//    }
    public List<DataExcel> loadExcel(MultipartFile file) throws IOException {

        DataExcel dataExcel = new DataExcel();


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
                if (rowNum > 4) {
//                Thông tin học sinh

                    String kidCode = row.getCell(1).getStringCellValue();
                    System.out.println("Đây là code.................. " + kidCode);
                    String name = row.getCell(2).getStringCellValue();
                    System.out.println("Đây là tên:........................" + name);
                    String birthday = row.getCell(3).getStringCellValue();
                    System.out.println("Đây là BirthDay.............................." + birthday);
                    System.out.println(birthday);
                    String parentPhone = row.getCell(4).getStringCellValue();
                    String nickName = row.getCell(5).getStringCellValue();
                    String nameClass = row.getCell(6).getStringCellValue();
                    String nameGrade = row.getCell(7).getStringCellValue();

//                Điểm danh học sinh
                    long arriveT2t6 = (long) row.getCell(8).getNumericCellValue();

                    System.out.println("Đây là số ngày t2-t6:..............." + arriveT2t6);

                    Long arriveT7 = (long) row.getCell(9).getNumericCellValue();
                    Long arriveCn = (long) row.getCell(10).getNumericCellValue();
                    Long absentCpT2t6 = (long) row.getCell(11).getNumericCellValue();
                    Long absentKpT2t6 = (long) row.getCell(12).getNumericCellValue();
                    Long absentCpT7 = (long) row.getCell(13).getNumericCellValue();
                    Long absentKpT7 = (long) row.getCell(14).getNumericCellValue();
                    Long leaveLater = (long) row.getCell(15).getNumericCellValue();
                    Long quantityDate = (long) row.getCell(16).getNumericCellValue();
                    System.out.println("DDaay laf tong ngayf.............." + quantityDate);


                    if (row.getCell(17).getCellType() == CellType.BLANK) {
                        row.getCell(17).setCellValue(0);
                    }
                    double beforeMoney = row.getCell(17).getNumericCellValue();
                    System.out.println("Đây là tiền còn lại ..................." + beforeMoney);


//                Khoản thu


                    if (row.getCell(18).getCellType() == CellType.BLANK) {
                        row.getCell(18).setCellValue(0);
                    }
                    double moneyKt1 = row.getCell(18).getNumericCellValue();


                    if (row.getCell(19).getCellType() == CellType.BLANK) {
                        row.getCell(19).setCellValue(0);
                    }
                    double moneyKt2 = row.getCell(19).getNumericCellValue();


                    if (row.getCell(20).getCellType() == CellType.BLANK) {
                        row.getCell(20).setCellValue(0);
                    }
                    double moneyKt3 = row.getCell(20).getNumericCellValue();


                    if (row.getCell(21).getCellType() == CellType.BLANK) {
                        row.getCell(21).setCellValue(0);
                    }
                    double moneyKt4 = row.getCell(21).getNumericCellValue();


                    if (row.getCell(22).getCellType() == CellType.BLANK) {
                        row.getCell(22).setCellValue(0);
                    }
                    double moneyKt5 = row.getCell(22).getNumericCellValue();


                    if (row.getCell(23).getCellType() == CellType.BLANK) {
                        row.getCell(23).setCellValue(0);
                    }
                    double moneyKt6 = row.getCell(23).getNumericCellValue();


                    if (row.getCell(24).getCellType() == CellType.BLANK) {
                        row.getCell(24).setCellValue(0);
                    }
                    double moneyKt7 = row.getCell(24).getNumericCellValue();


                    if (row.getCell(25).getCellType() == CellType.BLANK) {
                        row.getCell(25).setCellValue(0);
                    }
                    double moneyKt8 = row.getCell(25).getNumericCellValue();


                    if (row.getCell(26).getCellType() == CellType.BLANK) {
                        row.getCell(26).setCellValue(0);
                    }
                    double moneyKt9 = row.getCell(26).getNumericCellValue();


                    if (row.getCell(27).getCellType() == CellType.BLANK) {
                        row.getCell(27).setCellValue(0);
                    }
                    double moneyKt10 = row.getCell(27).getNumericCellValue();


                    if (row.getCell(28).getCellType() == CellType.BLANK) {
                        row.getCell(28).setCellValue(0);
                    }
                    double moneyKt11 = row.getCell(28).getNumericCellValue();


                    if (row.getCell(29).getCellType() == CellType.BLANK) {
                        row.getCell(29).setCellValue(0);
                    }
                    double moneyKt12 = row.getCell(29).getNumericCellValue();


                    if (row.getCell(30).getCellType() == CellType.BLANK) {
                        row.getCell(30).setCellValue(0);
                    }
                    double moneyKt13 = row.getCell(30).getNumericCellValue();


                    if (row.getCell(31).getCellType() == CellType.BLANK) {
                        row.getCell(31).setCellValue(0);
                    }
                    double moneyKt14 = row.getCell(31).getNumericCellValue();


                    if (row.getCell(32).getCellType() == CellType.BLANK) {
                        row.getCell(32).setCellValue(0);
                    }
                    double moneyKt15 = row.getCell(32).getNumericCellValue();


                    if (row.getCell(33).getCellType() == CellType.BLANK) {
                        row.getCell(33).setCellValue(0);
                    }
                    double moneyKt16 = row.getCell(33).getNumericCellValue();


                    if (row.getCell(34).getCellType() == CellType.BLANK) {
                        row.getCell(34).setCellValue(0);
                    }
                    double moneyKt17 = row.getCell(34).getNumericCellValue();


                    if (row.getCell(35).getCellType() == CellType.BLANK) {
                        row.getCell(35).setCellValue(0);
                    }
                    double moneyKt18 = row.getCell(35).getNumericCellValue();


                    if (row.getCell(36).getCellType() == CellType.BLANK) {
                        row.getCell(36).setCellValue(0);
                    }
                    double moneyKt19 = row.getCell(36).getNumericCellValue();


                    if (row.getCell(37).getCellType() == CellType.BLANK) {
                        row.getCell(37).setCellValue(0);
                    }
                    double moneyKt20 = row.getCell(37).getNumericCellValue();


//                Tổng tiền, tiền trả
                    if (row.getCell(38).getCellType() == CellType.BLANK) {
                        row.getCell(38).setCellValue(0);
                    }
                    double sumMoney = row.getCell(38).getNumericCellValue();


                    if (row.getCell(39).getCellType() == CellType.BLANK) {
                        row.getCell(39).setCellValue(0);
                    }
                    double collectedMoney = row.getCell(39).getNumericCellValue();


                    if (row.getCell(40).getCellType() == CellType.BLANK) {
                        row.getCell(40).setCellValue(0);
                    }
                    double cashMoney = row.getCell(40).getNumericCellValue();


                    if (row.getCell(41).getCellType() == CellType.BLANK) {
                        row.getCell(41).setCellValue(0);
                    }
                    double transferMoney = row.getCell(41).getNumericCellValue();


                    if (row.getCell(42).getCellType() == CellType.BLANK) {
                        row.getCell(42).setCellValue(0);
                    }
                    double afterMoney = row.getCell(42).getNumericCellValue();


                    String status = row.getCell(43).getStringCellValue();
                    String noteExcel1 = row.getCell(44).getStringCellValue();
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
            System.out.println(dataExcels.size());
            System.out.println(dataExcels);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataExcels;
    }


    public List<ResponseBeforeUpload> checkDataExcel(List<DataExcel> dataExcels) {

        ResponseBeforeUpload response = new ResponseBeforeUpload();

        System.out.println("................................................................................");

        System.out.println(dataExcels);

        for (int i = 0; i < dataExcels.size(); i++) {

            DataExcel data = dataExcels.get(i);

            //            Thông tin
            String code = data.getKidCode();
            String name = data.getNameKid();
            String birthday = data.getBirthday();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(birthday, formatter);
            String parentPhone = data.getParentPhone();
            String nickName = data.getNickName();
            String nameClass = data.getNameClass();
            String nameGrade = data.getNameGrade();

            //           Điểm danh
            Long arriveT2t6 = data.getArriveT2t6();
            Long arriveT7 = data.getArriveT7();
            Long arriveCn = data.getArriveCn();
            Long absentCpT2t6 = data.getAbsentCpT2t6();
            Long absentKpT2t6 = data.getAbsentKpT2t6();
            Long absentCpT7 = data.getAbsentCpT7();
            Long absentKpT7 = data.getAbsentKpT7();
            Long leaveLater = data.getLeaveLater();
            Long quantityDate = data.getQuantityDate();

            //            Khoản thu
            String nameKt1 = data.getNameKt1();
            String nameKt2 = data.getNameKt2();
            String nameKt3 = data.getNameKt3();
            String nameKt4 = data.getNameKt4();
            String nameKt5 = data.getNameKt5();
            String nameKt6 = data.getNameKt6();
            String nameKt7 = data.getNameKt7();
            String nameKt8 = data.getNameKt8();
            String nameKt9 = data.getNameKt9();
            String nameKt10 = data.getNameKt10();
            String nameKt11 = data.getNameKt11();
            String nameKt12 = data.getNameKt12();
            String nameKt13 = data.getNameKt13();
            String nameKt14 = data.getNameKt14();
            String nameKt15 = data.getNameKt15();
            String nameKt16 = data.getNameKt16();
            String nameKt17 = data.getNameKt17();
            String nameKt18 = data.getNameKt18();
            String nameKt19 = data.getNameKt19();
            String nameKt20 = data.getNameKt20();

            double moneyKt1 = data.getMoneyKt1();
            double moneyKt2 = data.getMoneyKt2();
            double moneyKt3 = data.getMoneyKt3();
            double moneyKt4 = data.getMoneyKt4();
            double moneyKt5 = data.getMoneyKt5();
            double moneyKt6 = data.getMoneyKt6();
            double moneyKt7 = data.getMoneyKt7();
            double moneyKt8 = data.getMoneyKt8();
            double moneyKt9 = data.getMoneyKt9();
            double moneyKt10 = data.getMoneyKt10();
            double moneyKt11 = data.getMoneyKt11();
            double moneyKt12 = data.getMoneyKt12();
            double moneyKt13 = data.getMoneyKt13();
            double moneyKt14 = data.getMoneyKt14();
            double moneyKt15 = data.getMoneyKt15();
            double moneyKt16 = data.getMoneyKt16();
            double moneyKt17 = data.getMoneyKt17();
            double moneyKt18 = data.getMoneyKt18();
            double moneyKt19 = data.getMoneyKt19();
            double moneyKt20 = data.getMoneyKt20();

            response.setKidCode(code);
            response.setName(name);
            response.setNameClass(nameClass);


            Kids kid = kidsServiceImpl.findKidByKidCode(code);

            if (kid == null) {
                response.setNotifyKidCode(AppConstant.WRONG_CHECK_DATA);
            }
            if (kid != null) {
                response.setNotifyKidCode(AppConstant.RIGHT_CHECK_DATA);

                if (
                        name.equals(kid.getFullName())
                                && date.equals(kid.getBirthDay())
                                && (parentPhone.equals(kid.getFatherPhone()) || parentPhone.equals(kid.getMotherPhone()))
                                && kid.getNickName().equals(nickName)
                                && nameClass.equals(classRepo.findById(kid.getMaClass().getId()))
                                && nameGrade.equals(gradeRepo.findById(kid.getIdGrade()))
                ) {
                    response.setNotifyInfo(AppConstant.RIGHT_CHECK_DATA);
                } else {
                    response.setNotifyInfo(AppConstant.WRONG_CHECK_DATA);

                }

                TotalKidsArrive totalKidsArrive = new TotalKidsArrive();

                OrderKidExcelDTO orderKidExcelDTO = null;

                switch (month) {
                    case 1:
                        OrderKidsExcelT01 orderKidsExcelT01 = orderKidExcelT01Repo.findByKidCode(code);
                        orderKidExcelDTO = modelMapper.map(orderKidsExcelT01, OrderKidExcelDTO.class);
                        totalKidsArrive= totalKidArriveRepo.getTotalKidsArriveByIdKidsAndMonth(kid.getId(),1);

                        break;
                    case 2:
                        OrderKidsExcelT02 orderKidsExcelT02 = orderKidExcelT02Repo.findByKidCode(code);
                        orderKidExcelDTO = modelMapper.map(orderKidsExcelT02, OrderKidExcelDTO.class);
                        totalKidsArrive= totalKidArriveRepo.getTotalKidsArriveByIdKidsAndMonth(kid.getId(),2);

                        break;
                    default:

                }

                if (
                        arriveT2t6.equals(totalKidsArrive.getArriveT2t6())
                                && arriveT7.equals(totalKidsArrive.getArriveT7())
                                && arriveCn.equals(totalKidsArrive.getArriveCn())
                                && absentCpT2t6.equals(totalKidsArrive.getAbsentCpT2t6())
                                && absentKpT2t6.equals(totalKidsArrive.getAbsentKpT2t6())
                                && absentCpT7.equals(totalKidsArrive.getAbsentCpT7())
                                && absentKpT7.equals(totalKidsArrive.getAbsentKpT7())
                                && leaveLater.equals(totalKidsArrive.getLeaveLater())
                                && quantityDate.equals(totalKidsArrive.getQuantityDate())
                ) {
                    response.setNotifyAttendance(AppConstant.RIGHT_CHECK_DATA);
                } else {
                    response.setNotifyAttendance(AppConstant.WRONG_CHECK_DATA);
                }

                if (orderKidExcelDTO != null) {

                    if (
                            nameKt1.equals(orderKidExcelDTO.getNameKt1())
                                    && nameKt2.equals(orderKidExcelDTO.getNameKt2())
                                    && nameKt3.equals(orderKidExcelDTO.getNameKt3())
                                    && nameKt4.equals(orderKidExcelDTO.getNameKt4())
                                    && nameKt5.equals(orderKidExcelDTO.getNameKt5())
                                    && nameKt6.equals(orderKidExcelDTO.getNameKt6())
                                    && nameKt7.equals(orderKidExcelDTO.getNameKt7())
                                    && nameKt8.equals(orderKidExcelDTO.getNameKt8())
                                    && nameKt9.equals(orderKidExcelDTO.getNameKt9())
                                    && nameKt10.equals(orderKidExcelDTO.getNameKt10())
                                    && nameKt11.equals(orderKidExcelDTO.getNameKt11())
                                    && nameKt12.equals(orderKidExcelDTO.getNameKt12())
                                    && nameKt13.equals(orderKidExcelDTO.getNameKt13())
                                    && nameKt14.equals(orderKidExcelDTO.getNameKt14())
                                    && nameKt15.equals(orderKidExcelDTO.getNameKt15())
                                    && nameKt16.equals(orderKidExcelDTO.getNameKt16())
                                    && nameKt17.equals(orderKidExcelDTO.getNameKt17())
                                    && nameKt18.equals(orderKidExcelDTO.getNameKt18())
                                    && nameKt19.equals(orderKidExcelDTO.getNameKt19())
                                    && nameKt20.equals(orderKidExcelDTO.getNameKt20())

                                    && moneyKt1 == orderKidExcelDTO.getMoneyKt1()
                                    && moneyKt2 == orderKidExcelDTO.getMoneyKt2()
                                    && moneyKt3 == orderKidExcelDTO.getMoneyKt3()
                                    && moneyKt4 == orderKidExcelDTO.getMoneyKt4()
                                    && moneyKt5 == orderKidExcelDTO.getMoneyKt5()
                                    && moneyKt6 == orderKidExcelDTO.getMoneyKt6()
                                    && moneyKt7 == orderKidExcelDTO.getMoneyKt7()
                                    && moneyKt8 == orderKidExcelDTO.getMoneyKt8()
                                    && moneyKt9 == orderKidExcelDTO.getMoneyKt9()
                                    && moneyKt10 == orderKidExcelDTO.getMoneyKt10()
                                    && moneyKt11 == orderKidExcelDTO.getMoneyKt11()
                                    && moneyKt12 == orderKidExcelDTO.getMoneyKt12()
                                    && moneyKt13 == orderKidExcelDTO.getMoneyKt13()
                                    && moneyKt14 == orderKidExcelDTO.getMoneyKt14()
                                    && moneyKt15 == orderKidExcelDTO.getMoneyKt15()
                                    && moneyKt16 == orderKidExcelDTO.getMoneyKt16()
                                    && moneyKt17 == orderKidExcelDTO.getMoneyKt17()
                                    && moneyKt18 == orderKidExcelDTO.getMoneyKt18()
                                    && moneyKt19 == orderKidExcelDTO.getMoneyKt19()
                                    && moneyKt20 == orderKidExcelDTO.getMoneyKt20()
                    ) {
                        response.setNotifyMoney(AppConstant.RIGHT_CHECK_DATA);

                    } else {
                        response.setNotifyMoney(AppConstant.WRONG_CHECK_DATA);
                    }


                } else {
                    response.setNotifyMoney(AppConstant.RIGHT_CHECK_DATA);
                }

            }


            responseBeforeUploads.add(response);

        }

        return responseBeforeUploads;
    }


}







