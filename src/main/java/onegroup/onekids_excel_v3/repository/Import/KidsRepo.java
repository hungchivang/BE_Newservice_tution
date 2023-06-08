package onegroup.onekids_excel_v3.repository.Import;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidsRepo extends JpaRepository<Kids,Long> {

    Kids findKidByKidCode(String kidCode);
}
