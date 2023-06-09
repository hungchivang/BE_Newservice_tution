package onegroup.onekids_excel_v3.controller.maClassController;

import onegroup.onekids_excel_v3.dto.MaClassAndDayOffClass;
import onegroup.onekids_excel_v3.service.ClassService.DayOffClassImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/maClass")
public class ClassController {

    @Autowired
    DayOffClassImpl dayOffClassImpl;

//    @Autowired
//    MaClassImpl maClassImpl;

//    @GetMapping("/dayOffClass/{idClass}")
//    public ResponseEntity<List<MaClassAndDayOffClass>> getMaClassAndDayOffClassByIdClass(@PathVariable long idClass) {
//        return new ResponseEntity<>(dayOffClassImpl.getMaClassAndDayOffClassByIdClass(idClass), HttpStatus.OK);
//    }

//    @GetMapping("/maClass/{idClass}")
//    public ResponseEntity<MaClass> getMaClassByIdClass(@PathVariable long idClass) {
//        return new ResponseEntity<>(maClassImpl.getMaClassByIdClass(idClass), HttpStatus.OK);
//    }
}
