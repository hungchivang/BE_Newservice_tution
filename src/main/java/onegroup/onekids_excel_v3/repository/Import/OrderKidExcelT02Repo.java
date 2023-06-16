package onegroup.onekids_excel_v3.repository.Import;

import onegroup.onekids_excel_v3.entity.excel.OrderKidsExcelT02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderKidExcelT02Repo extends JpaRepository<OrderKidsExcelT02,Long>{

    OrderKidsExcelT02 findByKidCodeAndCollectionTurn(String kidCode,int collectionTurn );


}
