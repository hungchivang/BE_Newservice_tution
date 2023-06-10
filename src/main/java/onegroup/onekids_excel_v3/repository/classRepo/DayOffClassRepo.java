package onegroup.onekids_excel_v3.repository.classRepo;

import onegroup.onekids_excel_v3.entity.entityv2.DayOffClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayOffClassRepo extends JpaRepository<DayOffClass,Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.day_off_class where id_class=:id_class and date between '2022-01-05' and '2022-02-04'")
    List<DayOffClass> getDayOffClassByIdClass(@Param("id_class") long id_class);
}
