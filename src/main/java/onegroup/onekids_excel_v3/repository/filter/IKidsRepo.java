package onegroup.onekids_excel_v3.repository.filter;

import onegroup.onekids_excel_v3.entity.entityv2.Kids;
import onegroup.onekids_excel_v3.entity.filter.CheckFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface IKidsRepo extends JpaRepository<Kids, Long> {
    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t01.status, ma_kids.full_name, ma_kids.nick_name \n" +
            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
            "join ma_class on ma_kids.id_class = ma_class.id\n" +
            "join order_kids_excel_t01 on ma_kids.id = order_kids_excel_t01.id_kids\n" +
            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t01.status = ?4 \n" +
            "and (ma_kids.full_name is null or ma_kids.full_name like ?5) and (ma_kids.nick_name is null or ma_kids.nick_name like ?6)")
    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT01(String kidStatus, String gradeName, String className, String status, String fullName, String nickName);

//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t02.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t02 on ma_kids.id = order_kids_excel_t02.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t02.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like :full_name) and (ma_kids.nick_name is null or ma_kids.nick_name like :nick_name)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT02(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);

//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t03.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t03 on ma_kids.id = order_kids_excel_t03.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t03.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT03(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t04.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t04 on ma_kids.id = order_kids_excel_t04.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t04.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT04(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t05.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t05 on ma_kids.id = order_kids_excel_t05.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t05.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT05(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t06.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t06 on ma_kids.id = order_kids_excel_t06.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t06.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT06(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t07.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t07 on ma_kids.id = order_kids_excel_t07.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t07.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT07(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t08.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t08 on ma_kids.id = order_kids_excel_t08.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t08.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT08(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t09.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t09 on ma_kids.id = order_kids_excel_t09.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t09.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT09(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t10.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t10 on ma_kids.id = order_kids_excel_t10.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t10.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT10(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t11.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t11 on ma_kids.id = order_kids_excel_t11.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t11.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT11(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);
//
//    @Query(nativeQuery = true, value = "select ma_kids.kid_status, ma_grade.grade_name, ma_class.class_name, order_kids_excel_t12.status, ma_kids.full_name, ma_kids.nick_name \n" +
//            "from ma_kids join ma_grade on ma_kids.id_grade = ma_grade.id\n" +
//            "join ma_class on ma_kids.id_class = ma_class.id\n" +
//            "join order_kids_excel_t12 on ma_kids.id = order_kids_excel_t12.id_kids\n" +
//            "WHERE ma_kids.kid_status = ?1 and ma_grade.grade_name = ?2 and ma_class.class_name = ?3 and order_kids_excel_t12.status = ?4 \n" +
//            "and (ma_kids.full_name is null or ma_kids.full_name like %:full_name%) and (ma_kids.nick_name is null or ma_kids.nick_name like %:nick_name%)")
//    List<CheckFilter> searchKidsAndGradeAndMaClassAndOrderKidsExcelT12(String kidStatus, String gradeName, String className, String status, @Param("full_name") String fullName,@Param("nick_name") String nickName);

}
