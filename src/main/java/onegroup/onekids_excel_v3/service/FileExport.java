package onegroup.onekids_excel_v3.service;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.excel.StatusExcel;
import onegroup.onekids_excel_v3.repository.statusExcel.StatusExcelRepo;
import onegroup.onekids_excel_v3.service.statusExcel.StatusExcelImpl;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static onegroup.onekids_excel_v3.common.AppConstant.EXPORT_EXCEL_COMPLETE;
import static onegroup.onekids_excel_v3.common.AppConstant.EXPORT_EXCEL_FAIL;

@Service
public class FileExport {

    @Autowired
    StatusExcelImpl statusExcelImpl;

    public XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Kids> listKids;



    public FileExport(List<Kids> listKids) {
        this.listKids = listKids;
        workbook = new XSSFWorkbook();
    }

    XSSFColor whiteOne = new XSSFColor(new java.awt.Color(255, 255, 255));
    XSSFColor Snow2One = new XSSFColor(new java.awt.Color(238, 233, 233));
    XSSFColor yellowOne = new XSSFColor(new java.awt.Color(255, 255, 0));
    XSSFColor greenOne = new XSSFColor(new java.awt.Color(120, 243, 136));
    XSSFColor darkSlateGray1 = new XSSFColor(new java.awt.Color(151, 255, 255));
    int[] widths = {10, 15, 30, 15, 17, 15, 25, 15, 15, 15, 15, 20, 24, 20, 20, 15, 25, 25, 15, 15,
            15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 20, 15, 15, 15, 20, 15, 25, 25, 25};
    DateFormat df = new SimpleDateFormat("MM/yyyy");
    Date currentDate = new Date();
    String dateToStr = df.format(currentDate);

    String[] COLUMNs = {"STT", "Mã học sinh", "Họ và tên", "Ngày sinh", "Số điện thoại", "Biệt danh", "Lớp", "Khối", "Học T2-T6", "Học T7", "Học CN", "Nghỉ có phép (T2-T6)",
            "Nghỉ không phép (T2-T6)", "Nghỉ có phép (T7)", "Nghỉ không phép  (T7)", "Đón muộn", "Số ngày theo lịch hàng tháng ", "Thiếu/Thừa tháng trước", "Khoản thu 1",
            "Khoản thu 2", "Khoản thu 3", "Khoản thu 4", "Khoản thu 5", "Khoản thu 6", "Khoản thu 7", "Khoản thu 8", "Khoản thu 9", "Khoản thu 10", "Khoản thu 11", "Khoản thu 12",
            "Khoản thu 13", "Khoản thu 14", "Khoản thu 15", "Khoản thu 16", "Khoản thu 17", "Khoản thu 18", "Khoản thu 19", "Khoản thu 20",
            "Phải thu tháng này", "Đã thu", "Tiền mặt", "Chuyển khoản", "Thiếu/Thừa còn lại", "Trạng thái", "(1) Ghi chú nhà trường", "(2) Ghi chú trên hóa đơn", "(3) Ghi chú khác"};

    public void writeHeaderLine(int month,int year) {

        sheet = workbook.createSheet("Danh sách HS");

        sheet.setDisplayGridlines(false);

        //Hiển thị phần ngoài bảng.
        for (int i = 0; i < 5; i++) {
            Row headerRow = sheet.createRow(i);
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                if (col == 0 && i == 0) {
                    cell.setCellValue("DANH SÁCH HỌC PHÍ CỦA HỌC SINH THỰC TẾ");
                    CellStyle cellStyle = workbook.createCellStyle();
                    Font cellFont = workbook.createFont();
                    cellFont.setFontHeightInPoints((short) 13);
                    cellFont.setBold(true);
                    cellFont.setColor(IndexedColors.RED.getIndex());

                    ((XSSFCellStyle) cellStyle).setFillForegroundColor(whiteOne);
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cellStyle.setFont(cellFont);
                    cell.setCellStyle(cellStyle);
                } else if (col == 0 && i == 1) {
                    cell.setCellValue("Trường : " + listKids.get(0).getMaClass().getGrade().getSchool().getSchoolName());
                    CellStyle twoStyle = workbook.createCellStyle();
                    Font cellFont = workbook.createFont();
                    cellFont.setBold(true);
                    ((XSSFCellStyle) twoStyle).setFillForegroundColor(whiteOne);
                    twoStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    twoStyle.setFont(cellFont);
                    cell.setCellStyle(twoStyle);
                } else if (col == 0 && i == 2) {
                    cell.setCellValue("Tháng : " + month + "/" + year);
                    CellStyle threeStyle = workbook.createCellStyle();
                    Font cellFont = workbook.createFont();
                    cellFont.setFontHeightInPoints((short) 11);
                    cellFont.setBold(true);
                    ((XSSFCellStyle) threeStyle).setFillForegroundColor(whiteOne);
                    threeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    threeStyle.setFont(cellFont);
                    cell.setCellStyle(threeStyle);
                } else {
                    CellStyle cellStyle = workbook.createCellStyle();
                    ((XSSFCellStyle) cellStyle).setFillForegroundColor(whiteOne);

                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell.setCellStyle(cellStyle);
                }
            }

        }

        Row row = sheet.createRow(4);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        // format độ rộng ô tiêu đề và căn giữa
        short height = 300;
        row.setHeight(height);
        XSSFCellStyle my_style_1 = workbook.createCellStyle();
        my_style_1.setAlignment(HorizontalAlignment.CENTER);
        my_style_1.setVerticalAlignment(VerticalAlignment.CENTER);
        row.setRowStyle(my_style_1);

        // Hiển thị tiêu đề cột
        for (int i = 0; i < COLUMNs.length; i++) {
            createCell(row, i, COLUMNs[i], style);
        }
    }


    public void createCell(Row row, int columnCount, Object value, CellStyle style) {
        // tạo phần cố định
        sheet.createFreezePane(8, 5);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        // Tạo màu
        CellStyle headerKidsCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerKidsCellStyle).setFillForegroundColor(whiteOne);
        headerKidsCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerKidsCellStyle.setFont(headerFont);
        headerKidsCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerKidsCellStyle.setBorderBottom(BorderStyle.THIN);
        headerKidsCellStyle.setBorderTop(BorderStyle.THIN);
        headerKidsCellStyle.setBorderRight(BorderStyle.THIN);
        headerKidsCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerMotherCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerMotherCellStyle).setFillForegroundColor(Snow2One);
        headerMotherCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerMotherCellStyle.setFont(headerFont);
        headerMotherCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerMotherCellStyle.setBorderBottom(BorderStyle.THIN);
        headerMotherCellStyle.setBorderTop(BorderStyle.THIN);
        headerMotherCellStyle.setBorderRight(BorderStyle.THIN);
        headerMotherCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerFatherCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerFatherCellStyle).setFillForegroundColor(greenOne);
        headerFatherCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerFatherCellStyle.setFont(headerFont);
        headerFatherCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerFatherCellStyle.setBorderBottom(BorderStyle.THIN);
        headerFatherCellStyle.setBorderTop(BorderStyle.THIN);
        headerFatherCellStyle.setBorderRight(BorderStyle.THIN);
        headerFatherCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerStudentCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerStudentCellStyle).setFillForegroundColor(yellowOne);
        headerStudentCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStudentCellStyle.setFont(headerFont);
        headerStudentCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStudentCellStyle.setBorderBottom(BorderStyle.THIN);
        headerStudentCellStyle.setBorderTop(BorderStyle.THIN);
        headerStudentCellStyle.setBorderRight(BorderStyle.THIN);
        headerStudentCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerMoneyCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerMoneyCellStyle).setFillForegroundColor(darkSlateGray1);
        headerMoneyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerMoneyCellStyle.setFont(headerFont);
        headerMoneyCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerMoneyCellStyle.setBorderBottom(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderTop(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderRight(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderLeft(BorderStyle.THIN);

        // cài đặt màu cho tiêu đề cột
        for (int col = 0; col < COLUMNs.length; col++) {
            sheet.setColumnWidth(col, widths[col] * 256);
            Cell cell = row.createCell(col);
            cell.setCellValue(COLUMNs[col]);
            if (col < 7) {
                cell.setCellStyle(headerKidsCellStyle);
            } else if (col > 7 && col < 17) {
                cell.setCellStyle(headerMotherCellStyle);
            } else if (col > 17 && col < 38) {
                cell.setCellStyle(headerStudentCellStyle);
            } else if (col > 38 && col < 42) {
                cell.setCellStyle(headerFatherCellStyle);
            } else if (col == 17 || col ==42 || col==38) {
                cell.setCellStyle(headerMoneyCellStyle);
            } else {
                cell.setCellStyle(headerKidsCellStyle);
            }

        }

    }

    public void writeDataLines() {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerKidsCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerKidsCellStyle).setFillForegroundColor(whiteOne);
        headerKidsCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerKidsCellStyle.setFont(headerFont);
        headerKidsCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerKidsCellStyle.setBorderBottom(BorderStyle.THIN);
        headerKidsCellStyle.setBorderTop(BorderStyle.THIN);
        headerKidsCellStyle.setBorderRight(BorderStyle.THIN);
        headerKidsCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerMotherCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerMotherCellStyle).setFillForegroundColor(Snow2One);
        headerMotherCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerMotherCellStyle.setFont(headerFont);
        headerMotherCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerMotherCellStyle.setBorderBottom(BorderStyle.THIN);
        headerMotherCellStyle.setBorderTop(BorderStyle.THIN);
        headerMotherCellStyle.setBorderRight(BorderStyle.THIN);
        headerMotherCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerFatherCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerFatherCellStyle).setFillForegroundColor(greenOne);
        headerFatherCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerFatherCellStyle.setFont(headerFont);
        headerFatherCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerFatherCellStyle.setBorderBottom(BorderStyle.THIN);
        headerFatherCellStyle.setBorderTop(BorderStyle.THIN);
        headerFatherCellStyle.setBorderRight(BorderStyle.THIN);
        headerFatherCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerStudentCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerStudentCellStyle).setFillForegroundColor(yellowOne);
        headerStudentCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStudentCellStyle.setFont(headerFont);
        headerStudentCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStudentCellStyle.setBorderBottom(BorderStyle.THIN);
        headerStudentCellStyle.setBorderTop(BorderStyle.THIN);
        headerStudentCellStyle.setBorderRight(BorderStyle.THIN);
        headerStudentCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle headerMoneyCellStyle = workbook.createCellStyle();
        ((XSSFCellStyle) headerMoneyCellStyle).setFillForegroundColor(darkSlateGray1);
        headerMoneyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerMoneyCellStyle.setFont(headerFont);
        headerMoneyCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerMoneyCellStyle.setBorderBottom(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderTop(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderRight(BorderStyle.THIN);
        headerMoneyCellStyle.setBorderLeft(BorderStyle.THIN);

        CellStyle contentCellStyle = workbook.createCellStyle();
        Font contentFont = workbook.createFont();
        contentFont.setColor(IndexedColors.BLACK.getIndex());
        contentCellStyle.setFont(contentFont);
        contentCellStyle.setWrapText(true);
        contentCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentCellStyle.setAlignment(HorizontalAlignment.CENTER);
        contentCellStyle.setBorderBottom(BorderStyle.THIN);
        contentCellStyle.setBorderTop(BorderStyle.THIN);
        contentCellStyle.setBorderRight(BorderStyle.THIN);
        contentCellStyle.setBorderLeft(BorderStyle.THIN);

        int rowCount = 5;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        // lấy dữ liệu từ DB vào từng ô
        for (Kids kid : listKids) {
            Row row = sheet.createRow(rowCount++);

            Cell cellStt = row.createCell(0);
            cellStt.setCellValue(kid.getId());
            cellStt.setCellStyle(contentCellStyle);


            Cell cellStt1 = row.createCell(1);
            cellStt1.setCellValue(kid.getKidCode());
            cellStt1.setCellStyle(contentCellStyle);

            Cell cellStt2 = row.createCell(2);
            cellStt2.setCellValue(kid.getFullName());
            cellStt2.setCellStyle(contentCellStyle);

            Cell cellStt3 = row.createCell(3);
            cellStt3.setCellValue(kid.getBirthDay());
            cellStt3.setCellStyle(contentCellStyle);

            Cell cellStt4 = row.createCell(4);
            cellStt4.setCellValue(kid.getFatherPhone());
            cellStt4.setCellStyle(contentCellStyle);

            Cell cellStt5 = row.createCell(5);
            cellStt5.setCellValue(kid.getNickName());
            cellStt5.setCellStyle(contentCellStyle);

            Cell cellStt6 = row.createCell(6);
            cellStt6.setCellValue(kid.getMaClass().getClassName());
            cellStt6.setCellStyle(contentCellStyle);

            Cell cellStt7 = row.createCell(7);
            cellStt7.setCellValue(kid.getMaClass().getGrade().getGradeName());
            cellStt7.setCellStyle(contentCellStyle);

            Cell cellStt8 = row.createCell(8);
            cellStt8.setCellValue("");
            cellStt8.setCellStyle(contentCellStyle);
            cellStt8.setCellStyle(headerMotherCellStyle);

            Cell cellStt9 = row.createCell(9);
            cellStt9.setCellValue("");
            cellStt9.setCellStyle(contentCellStyle);
            cellStt9.setCellStyle(headerMotherCellStyle);

            Cell cellStt10 = row.createCell(10);
            cellStt10.setCellValue("");
            cellStt10.setCellStyle(contentCellStyle);
            cellStt10.setCellStyle(headerMotherCellStyle);

            Cell cellStt11 = row.createCell(11);
            cellStt11.setCellValue("");
            cellStt11.setCellStyle(contentCellStyle);
            cellStt11.setCellStyle(headerMotherCellStyle);

            Cell cellStt12 = row.createCell(12);
            cellStt12.setCellValue("");
            cellStt12.setCellStyle(contentCellStyle);
            cellStt12.setCellStyle(headerMotherCellStyle);

            Cell cellStt13 = row.createCell(13);
            cellStt13.setCellValue("");
            cellStt13.setCellStyle(contentCellStyle);
            cellStt13.setCellStyle(headerMotherCellStyle);

            Cell cellStt14 = row.createCell(14);
            cellStt14.setCellValue("");
            cellStt14.setCellStyle(contentCellStyle);
            cellStt14.setCellStyle(headerMotherCellStyle);

            Cell cellStt15 = row.createCell(15);
            cellStt15.setCellValue("");
            cellStt15.setCellStyle(contentCellStyle);
            cellStt15.setCellStyle(headerMotherCellStyle);

            Cell cellStt16 = row.createCell(16);
            cellStt16.setCellValue("");
            cellStt16.setCellStyle(contentCellStyle);
            cellStt16.setCellStyle(headerMotherCellStyle);

            Cell cellStt17 = row.createCell(17);
            cellStt17.setCellValue("");
            cellStt17.setCellStyle(contentCellStyle);
            cellStt17.setCellStyle(headerMoneyCellStyle);

            Cell cellStt18 = row.createCell(18);
            cellStt18.setCellValue("");
            cellStt18.setCellStyle(contentCellStyle);
            cellStt18.setCellStyle(headerStudentCellStyle);

            Cell cellStt19 = row.createCell(19);
            cellStt19.setCellValue("");
            cellStt19.setCellStyle(contentCellStyle);
            cellStt19.setCellStyle(headerStudentCellStyle);

            Cell cellStt20 = row.createCell(20);
            cellStt20.setCellValue("");
            cellStt20.setCellStyle(contentCellStyle);
            cellStt20.setCellStyle(headerStudentCellStyle);

            Cell cellStt21 = row.createCell(21);
            cellStt21.setCellValue("");
            cellStt21.setCellStyle(contentCellStyle);
            cellStt21.setCellStyle(headerStudentCellStyle);

            Cell cellStt22 = row.createCell(22);
            cellStt22.setCellValue("");
            cellStt22.setCellStyle(contentCellStyle);
            cellStt22.setCellStyle(headerStudentCellStyle);

            Cell cellStt23 = row.createCell(23);
            cellStt23.setCellValue("");
            cellStt23.setCellStyle(contentCellStyle);
            cellStt23.setCellStyle(headerStudentCellStyle);

            Cell cellStt24 = row.createCell(24);
            cellStt24.setCellValue("");
            cellStt24.setCellStyle(contentCellStyle);
            cellStt24.setCellStyle(headerStudentCellStyle);

            Cell cellStt25 = row.createCell(25);
            cellStt25.setCellValue("");
            cellStt25.setCellStyle(contentCellStyle);
            cellStt25.setCellStyle(headerStudentCellStyle);

            Cell cellStt26 = row.createCell(26);
            cellStt26.setCellValue("");
            cellStt26.setCellStyle(contentCellStyle);
            cellStt26.setCellStyle(headerStudentCellStyle);

            Cell cellStt27 = row.createCell(27);
            cellStt27.setCellValue("");
            cellStt27.setCellStyle(contentCellStyle);
            cellStt27.setCellStyle(headerStudentCellStyle);

            Cell cellStt28 = row.createCell(28);
            cellStt28.setCellValue("");
            cellStt28.setCellStyle(contentCellStyle);
            cellStt28.setCellStyle(headerStudentCellStyle);

            Cell cellStt29 = row.createCell(29);
            cellStt29.setCellValue("");
            cellStt29.setCellStyle(contentCellStyle);
            cellStt29.setCellStyle(headerStudentCellStyle);

            Cell cellStt30 = row.createCell(30);
            cellStt30.setCellValue("");
            cellStt30.setCellStyle(contentCellStyle);
            cellStt30.setCellStyle(headerStudentCellStyle);

            Cell cellStt31 = row.createCell(31);
            cellStt31.setCellValue("");
            cellStt31.setCellStyle(contentCellStyle);
            cellStt31.setCellStyle(headerStudentCellStyle);

            Cell cellStt32 = row.createCell(32);
            cellStt32.setCellValue("");
            cellStt32.setCellStyle(contentCellStyle);
            cellStt32.setCellStyle(headerStudentCellStyle);

            Cell cellStt33 = row.createCell(33);
            cellStt33.setCellValue("");
            cellStt33.setCellStyle(contentCellStyle);
            cellStt33.setCellStyle(headerStudentCellStyle);

            Cell cellStt34 = row.createCell(34);
            cellStt34.setCellValue("");
            cellStt34.setCellStyle(contentCellStyle);
            cellStt34.setCellStyle(headerStudentCellStyle);

            Cell cellStt35 = row.createCell(35);
            cellStt35.setCellValue("");
            cellStt35.setCellStyle(contentCellStyle);
            cellStt35.setCellStyle(headerStudentCellStyle);

            Cell cellStt36 = row.createCell(36);
            cellStt36.setCellValue("");
            cellStt36.setCellStyle(contentCellStyle);
            cellStt36.setCellStyle(headerStudentCellStyle);

            Cell cellStt37 = row.createCell(37);
            cellStt37.setCellValue("");
            cellStt37.setCellStyle(contentCellStyle);
            cellStt37.setCellStyle(headerStudentCellStyle);

            Cell cellStt38 = row.createCell(38);
            cellStt38.setCellValue("");
            cellStt38.setCellStyle(contentCellStyle);
            cellStt38.setCellStyle(headerMoneyCellStyle);


            Cell cellStt39 = row.createCell(39);
            cellStt39.setCellValue("");
            cellStt39.setCellStyle(contentCellStyle);
            cellStt39.setCellStyle(headerStudentCellStyle);

            Cell cellStt40 = row.createCell(40);
            cellStt40.setCellValue("");
            cellStt40.setCellStyle(contentCellStyle);
            cellStt40.setCellStyle(headerStudentCellStyle);

            Cell cellStt41 = row.createCell(41);
            cellStt41.setCellValue("");
            cellStt41.setCellStyle(contentCellStyle);
            cellStt41.setCellStyle(headerStudentCellStyle);


            Cell cellStt42 = row.createCell(42);
            cellStt42.setCellValue("");
            cellStt42.setCellStyle(contentCellStyle);
            cellStt42.setCellStyle(headerMoneyCellStyle);

            Cell cellStt43 = row.createCell(43);
            cellStt43.setCellValue("");
            cellStt43.setCellStyle(contentCellStyle);


            Cell cellStt44 = row.createCell(44);
            cellStt44.setCellValue("");
            cellStt44.setCellStyle(contentCellStyle);

            Cell cellStt45 = row.createCell(45);
            cellStt45.setCellValue("");
            cellStt45.setCellStyle(contentCellStyle);

            Cell cellStt46 = row.createCell(46);
            cellStt46.setCellValue("");
            cellStt46.setCellStyle(contentCellStyle);


        }
    }

    public void export(HttpServletResponse response,String guiId,int month,int year) throws IOException {

        StatusExcel statusExcel = statusExcelImpl.findByGuiId(guiId);
        String fileName = statusExcel.getFileName();
        String pathFile = "C:\\Users\\ADMIN\\Desktop\\OneKids\\Code-BackEnd\\Main\\BE_Newservice_tution\\src\\main\\java\\onegroup\\onekids_excel_v3\\uploadExcel\\" + fileName ;
        writeHeaderLine(month,year);
        writeDataLines();
        try{
            FileOutputStream outputStream = new FileOutputStream(pathFile);
            workbook.write(outputStream);

            statusExcel.setStatus(EXPORT_EXCEL_COMPLETE);
            statusExcelImpl.save(statusExcel);
            workbook.close();
            outputStream.close();
        }catch(IOException ex) {
            statusExcel.setStatus(EXPORT_EXCEL_FAIL);
            statusExcelImpl.save(statusExcel);
            workbook.close();
            ex.printStackTrace();
        }
    }


}
