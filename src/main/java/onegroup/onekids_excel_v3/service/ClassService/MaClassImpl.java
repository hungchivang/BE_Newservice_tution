package onegroup.onekids_excel_v3.service.ClassService;

import onegroup.onekids_excel_v3.entity.entityv2.DayOffClass;
import onegroup.onekids_excel_v3.entity.entityv2.MaClass;
import onegroup.onekids_excel_v3.repository.classRepo.MaClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaClassImpl {

    @Autowired
    MaClassRepo maClassRepo;

    public MaClass getMaClassByIdClass(long idClass){
        return maClassRepo.getMaClassByIdClass(idClass);
    }
}
