package onegroup.onekids_excel_v3.repository.Import;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderKidExcelT01Repo extends JpaRepository<OrderKidsExcelT01,Long>{


}
