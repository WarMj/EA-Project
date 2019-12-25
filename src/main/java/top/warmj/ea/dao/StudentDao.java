package top.warmj.ea.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.warmj.ea.domain.StudentDO;

import java.util.List;

/**
 * 学生信息列表
 * dao层
 *
 * @author WarMj
 * @date 2018-05-16
 */
@Mapper
@Repository
public interface StudentDao {
  /**
   * @return
   */
  List<StudentDO> listStudentInformation();

  /**
   * @param sid
   * @return
   */
  List<StudentDO> selectStudentBySid(@Param("sid") String sid);

  /**
   * 根据学号删除学生
   * @param sid
   * @return
   */
  int deleteStudentBySid(@Param("sid") String sid);

  /**
   * 根据学号更新学生
   * @param sid
   * @param college
   * @return
   */
  int updateStudentBySid(@Param("sid") String sid, @Param("name") String name, @Param("sex") String sex,
                         @Param("university") String university, @Param("college") String college,
                         @Param("major") String major, @Param("sClass") String sClass);


  /**
   * 添加学生
   * @param sid
   * @param college
   * @return
   */
  int insertStudent(@Param("sid") String sid, @Param("name") String name, @Param("sex") String sex,
                    @Param("university") String university, @Param("college") String college,
                    @Param("major") String major, @Param("sClass") String sClass);
}
