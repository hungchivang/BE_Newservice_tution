package onegroup.onekids_excel_v3.controller.filter;

import onegroup.onekids_excel_v3.dto.filter.OrderKidsExcelDTO;
import onegroup.onekids_excel_v3.service.filter.OrderKidsExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show/orderexcel")
public class OrderKidsExcelT01API {
    @Autowired
    OrderKidsExcelService orderKidsExcelService;
    @GetMapping("/{month}")

    public List<OrderKidsExcelDTO> findAllOrderKidsExcel(@PathVariable int month) {
        return orderKidsExcelService.findAllOrderKidsExcel(month);
    }
}
