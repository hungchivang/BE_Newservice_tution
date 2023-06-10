package onegroup.onekids_excel_v3.repository.classRepo;

import onegroup.onekids_excel_v3.entity.entityv2.MaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MaClassRepo extends JpaRepository<MaClass,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.ma_class where id =:id")
    MaClass getMaClassByIdClass(@Param("id") long id);

}
