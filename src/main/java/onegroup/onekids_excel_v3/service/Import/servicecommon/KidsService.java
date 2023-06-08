package onegroup.onekids_excel_v3.service.Import.servicecommon;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.repository.Import.KidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface KidsService {



    Kids findKidByKidCode(String kidCode);







    List<Kids> getAll();






}
