package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderKidsExcelT07Repo extends JpaRepository<OrderKidsExcelT07, Long> {
}
