package top.warmj.ea.services;

import top.warmj.ea.domain.StudentDO;

import java.util.List;

/**
 * 学生信息列表
 * service层
 *
 * @author WarMj
 * @date 2018-05-16
 */
public interface StudentService {
  List<StudentDO> listStudentInformation();

  List<StudentDO> selectStudentBySid(String sid);

  int deleteStudentBySid(String sid);

  int updateStudentBySid(String sid, String name, String sex, String university, String college, String major, String sClass);

  int insertStudent(String sid, String name, String sex, String university, String college, String major, String sClass);

}