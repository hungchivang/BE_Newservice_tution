//package onegroup.onekids_excel_v3.controller.filter;
//
//import onegroup.onekids_excel_v3.entity.filter.CheckFilter;
//import onegroup.onekids_excel_v3.service.filter.OrderKidsExcelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/show/orderexcel")
//public class OrderKidsExcelT01API {
//    @Autowired
//    OrderKidsExcelService orderKidsExcelService;
//    @GetMapping("/{month}")
//
//    public List<CheckFilter> findAllOrderKidsExcel(@PathVariable int month, @RequestParam ("key") String kidStatus, @RequestParam ("key") String gradeName,
//                                                   @RequestParam ("key") String className, @RequestParam ("key") String status, @RequestParam ("key") String fullName,
//                                                   @RequestParam ("key") String nickName){
//        return orderKidsExcelService.findAllOrderKidsExcel(month, kidStatus, gradeName, className, status, fullName, nickName);
//
//    }
//}
