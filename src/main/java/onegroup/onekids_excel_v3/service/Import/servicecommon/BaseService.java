package onegroup.onekids_excel_v3.service.Import.servicecommon;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<T> {
    List<T> getAll();


    T create(T t) ;

    T edit (T t);
}
