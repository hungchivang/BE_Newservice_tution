package onegroup.onekids_excel_v3.service.Import.serviceimpl;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT01;
import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT02;
import onegroup.onekids_excel_v3.repository.Import.OrderKidExcelT01Repo;
import onegroup.onekids_excel_v3.repository.Import.OrderKidExcelT02Repo;
import onegroup.onekids_excel_v3.service.Import.servicecommon.OrderKidExcelT01Service;
import onegroup.onekids_excel_v3.service.Import.servicecommon.OrderKidExcelT02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderKidExcelT02ServiceImpl implements OrderKidExcelT02Service {
    @Autowired
    OrderKidExcelT02Repo orderKidExcelT02Repo;


    @Override
    public List<OrderKidsExcelT02> getAll() {
        List<OrderKidsExcelT02> orderKidsExcelT02s = orderKidExcelT02Repo.findAll();

        return orderKidsExcelT02s;
    }

    @Override
    public OrderKidsExcelT02 create(OrderKidsExcelT02 orderKidsExcelT02) {
        orderKidExcelT02Repo.save(orderKidsExcelT02);
        return orderKidsExcelT02;
    }

    @Override
    public OrderKidsExcelT02 edit(OrderKidsExcelT02 orderKidsExcelT02) {
        orderKidExcelT02Repo.save(orderKidsExcelT02);
        return orderKidsExcelT02;
    }
}
