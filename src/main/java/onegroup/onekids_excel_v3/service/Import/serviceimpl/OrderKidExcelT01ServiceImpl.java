package onegroup.onekids_excel_v3.service.Import.serviceimpl;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT01;
import onegroup.onekids_excel_v3.repository.Import.OrderKidExcelT01Repo;
import onegroup.onekids_excel_v3.service.Import.servicecommon.OrderKidExcelT01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderKidExcelT01ServiceImpl implements OrderKidExcelT01Service {
    @Autowired
    OrderKidExcelT01Repo orderKidExcelT01Repo;


    @Override
    public List<OrderKidsExcelT01> getAll() {
        List<OrderKidsExcelT01> orderKidsExcelT01s = orderKidExcelT01Repo.findAll();

        return orderKidsExcelT01s;
    }

    @Override
    public OrderKidsExcelT01 create(OrderKidsExcelT01 orderKidsExcelT01) {
        orderKidExcelT01Repo.save(orderKidsExcelT01);
        return orderKidsExcelT01;
    }

    @Override
    public OrderKidsExcelT01 edit(OrderKidsExcelT01 orderKidsExcelT01) {
        orderKidExcelT01Repo.save(orderKidsExcelT01);
        return orderKidsExcelT01;
    }
}
