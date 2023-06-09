package onegroup.onekids_excel_v3.repository.classRepo;

import onegroup.onekids_excel_v3.dto.MaClassAndDayOffClass;
import onegroup.onekids_excel_v3.entity.entityv2.DayOffClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayOffClassRepo extends JpaRepository<DayOffClass,Long> {

//    @Query(nativeQuery = true, value = "SELECT day_off_class.id as id_dayOffClass,day_off_class.date,ma_class.id as id_class,ma_class.morning_saturday,ma_class.afternoon_saturday,\n" +
//            "ma_class.evening_saturday,ma_class.sunday FROM app_onekids_2.day_off_class \n" +
//            "JOIN ma_class on ma_class.id = day_off_class.id_class where id_class=:id_class and date between '2022-01-05' and '2022-02-04'")
//    List<MaClassAndDayOffClass> getMaClassAndDayOffClassByIdClass(@Param("id_class") long id_class);

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.day_off_class where id_class=:id_class and date between '2022-01-05' and '2022-02-04'")
    List<DayOffClass> getDayOffClassByIdClass(@Param("id_class") long id_class);
}
