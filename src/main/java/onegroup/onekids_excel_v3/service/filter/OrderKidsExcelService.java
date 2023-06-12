//package onegroup.onekids_excel_v3.service.filter;
//
//import onegroup.onekids_excel_v3.dto.filter.OrderKidsExcelDTO;
//import onegroup.onekids_excel_v3.entity.excel.*;
//import onegroup.onekids_excel_v3.entity.filter.CheckFilter;
//import onegroup.onekids_excel_v3.repository.filter.*;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class OrderKidsExcelService {
//    @Autowired
//    IKidsRepo iKidsRepo;
//    public List<CheckFilter> findAllOrderKidsExcel(int month, String kidStatus, String gradeName, String className, String status, String fullName, String nickName) {
//        switch (month) {
//
//            case 1:
//                List<CheckFilter> checkFilters01 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT01(kidStatus, gradeName, className, status, fullName, nickName);
//                return checkFilters01;
////            case 2:
////                List<CheckFilter> checkFilters02 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT02(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters02;
////
////            case 3:
////                List<CheckFilter> checkFilters03 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT03(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters03;
////
////            case 4:
////                List<CheckFilter> checkFilters04 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT04(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters04;
////
////            case 5:
////                List<CheckFilter> checkFilters05 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT05(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters05;
////
////            case 6:
////                List<CheckFilter> checkFilters06 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT06(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters06;
////
////            case 7:
////                List<CheckFilter> checkFilters07 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT07(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters07;
////
////            case 8:
////                List<CheckFilter> checkFilters08 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT08(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters08;
////
////            case 9:
////                List<CheckFilter> checkFilters09 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT09(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters09;
////
////            case 10:
////                List<CheckFilter> checkFilters10 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT10(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters10;
////
////            case 11:
////                List<CheckFilter> checkFilters11 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT11(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters11;
////
////            case 12:
////                List<CheckFilter> checkFilters12 = iKidsRepo.searchKidsAndGradeAndMaClassAndOrderKidsExcelT12(kidStatus, gradeName, className, status, fullName, nickName);
////                return checkFilters12;
//
//        }
//        return null;
//    }
//}
