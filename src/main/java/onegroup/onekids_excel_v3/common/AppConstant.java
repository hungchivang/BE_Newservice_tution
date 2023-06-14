package onegroup.onekids_excel_v3.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface AppConstant {
    boolean APP_TRUE = true;
    boolean APP_FALSE = false;
    String YES = "yes";
    String NO = "no";
    int PAGE_NUMBER = 0;
    int MAX_PAGE_ITEM = 20;
    long NUMBER_ZERO = 0L;
    int ZERO = 0;
    int ONE = 1;

    String EXPORT_EXCEL_PROCESSING = "processing";
    String EXPORT_EXCEL_COMPLETE = "complete";
    String EXPORT_EXCEL_FAIL = "fail";
    LocalTime TIME_LEAVE_KID_DEFAULT = LocalTime.of(17, 0, 0);
    long TIME_LEAVE_KID_BLOCK = 10L;

    String NO_HAVE_BILLS = "Chưa có hóa đơn";
    String NO_MONEY_PAYMENT = "Chưa đóng";
    String NO_MONEY_PAYMENT_FULL = "Chưa đóng đủ";
    String YES_MONEY_PAYMENT_FULL = "Đóng đủ";
    String YES_PAYMENT_OVERALL_MONEY = "Đóng thừa";






}
