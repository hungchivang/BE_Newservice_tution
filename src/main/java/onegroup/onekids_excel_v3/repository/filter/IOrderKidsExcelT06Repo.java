package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderKidsExcelT06Repo extends JpaRepository<OrderKidsExcelT06, Long> {
}
