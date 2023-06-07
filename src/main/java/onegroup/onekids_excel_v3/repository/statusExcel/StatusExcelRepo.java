package onegroup.onekids_excel_v3.repository.statusExcel;



import onegroup.onekids_excel_v3.entity.excel.StatusExcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusExcelRepo extends JpaRepository<StatusExcel,String> {

    @Query(nativeQuery = true, value = "select * from status_excel where id_guid = ?1")
    StatusExcel findByGuiId(String guiId);
}
