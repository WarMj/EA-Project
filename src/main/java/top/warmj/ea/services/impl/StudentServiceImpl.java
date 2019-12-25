package top.warmj.ea.services.impl;

import top.warmj.ea.dao.StudentDao;
import top.warmj.ea.domain.StudentDO;
import top.warmj.ea.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  /**
   *
   * @return
   */
  @Override
  public List<StudentDO> listStudentInformation() {
    return studentDao.listStudentInformation();
  }

  /**
   *
   * @param sid
   * @return
   */
  @Override
  public List<StudentDO> selectStudentBySid(String sid) {
    return studentDao.selectStudentBySid(sid);
  }

  /**
   * 根据学号删除学生
   * @param sid
   * @return
   */
  @Override
  public int deleteStudentBySid(String sid) {
    return studentDao.deleteStudentBySid(sid);
  }

  /**
   * 根据学号更新学生
   * @param sid
   * @return
   */
  @Override
  public int updateStudentBySid(String sid, String name, String sex, String university, String college, String major, String sClass) {
    return studentDao.updateStudentBySid(sid, name, sex, university, college, major, sClass);
  }

  @Override
  public int insertStudent(String sid, String name, String sex, String university, String college, String major, String sClass) {
    return studentDao.insertStudent(sid, name, sex, university, college, major, sClass);
  }


}
