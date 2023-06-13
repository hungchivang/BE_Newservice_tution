package onegroup.onekids_excel_v3.service.attendance;

import onegroup.onekids_excel_v3.entity.entityv2.CycleMoney;
import onegroup.onekids_excel_v3.repository.attendance.CycleMoneyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CycleMoneyImpl {

    @Autowired
    CycleMoneyRepo cycleMoneyRepo;

    public CycleMoney findCycleMoneyByIdSchool(long idSchool){
        return cycleMoneyRepo.findCycleMoneyByIdSchool(idSchool);
    }
}
