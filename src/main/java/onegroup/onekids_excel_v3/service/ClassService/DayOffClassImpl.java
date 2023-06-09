package onegroup.onekids_excel_v3.service.ClassService;

import onegroup.onekids_excel_v3.dto.MaClassAndDayOffClass;
import onegroup.onekids_excel_v3.entity.entityv2.DayOffClass;
import onegroup.onekids_excel_v3.repository.classRepo.DayOffClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOffClassImpl {

    @Autowired
    DayOffClassRepo dayOffClassRepo;

//    public List<MaClassAndDayOffClass> getMaClassAndDayOffClassByIdClass(long id_class){
//        return dayOffClassRepo.getMaClassAndDayOffClassByIdClass(id_class);
//    }

    public List<DayOffClass> getDayOffClassByIdClass(long id_class){
        return dayOffClassRepo.getDayOffClassByIdClass(id_class);
    }
}
