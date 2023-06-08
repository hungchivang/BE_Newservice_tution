package onegroup.onekids_excel_v3.service.Import.serviceimpl;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.repository.Import.KidsRepo;
import onegroup.onekids_excel_v3.service.Import.servicecommon.KidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KidsServiceImpl implements KidsService {
    @Autowired
    KidsRepo kidsRepo;


    @Override
    public Kids findKidByKidCode(String kidCode) {
        return kidsRepo.findKidByKidCode(kidCode);
    }

    @Override
    public List<Kids> getAll() {
        List<Kids> kids=kidsRepo.findAll();
        return kids;
    }


}
