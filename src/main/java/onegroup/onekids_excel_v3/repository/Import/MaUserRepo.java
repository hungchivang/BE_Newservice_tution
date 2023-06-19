package onegroup.onekids_excel_v3.repository.Import;

import onegroup.onekids_excel_v3.entity.entityv2.MaClass;
import onegroup.onekids_excel_v3.entity.entityv2.MaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaUserRepo extends JpaRepository<MaUser,Long> {

}
