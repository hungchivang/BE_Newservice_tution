package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderKidsExcelT08Repo extends JpaRepository<OrderKidsExcelT08, Long> {
}
