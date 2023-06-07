package onegroup.onekids_excel_v3.service.kids;


import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.repository.kids.KidsExcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidExcelService{

    @Autowired
    KidsExcelRepo kidsExcelRepo;

    public List<Kids> findAllByIdSchool(long idSchool) {
        return kidsExcelRepo.findAllByIdSchool(idSchool);
    }

    public List<Kids> findAll() {
        return kidsExcelRepo.findAll();
    }
}
