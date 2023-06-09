package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderKidsExcelT10Repo extends JpaRepository<OrderKidsExcelT10, Long> {
}
