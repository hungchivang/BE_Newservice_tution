package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderKidsExcelT05Repo extends JpaRepository<OrderKidsExcelT05, Long> {
}
