package onegroup.onekids_excel_v3.repository.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.CycleMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CycleMoneyRepo extends JpaRepository<CycleMoney,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM app_onekids_2.cycle_money where id_school=:id_school ")
    CycleMoney findCycleMoneyByIdSchool(@Param("id_school") long idSchool);
}
