package top.warmj.ea.controller;

import org.springframework.web.bind.annotation.*;
import top.warmj.ea.domain.StudentDO;
import top.warmj.ea.services.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * 学生信息列表
 * controller层
 *
 * @author WarMj
 * @date 2018-05-16
 */
@CrossOrigin
@Controller
@RequestMapping("student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;

  }

  /**
   * 列出所有学生
   * @return
   */
  @GetMapping("listStudentInformation")
  @ResponseBody
  public List<StudentDO> listStudentInformation() {
    return studentService.listStudentInformation();
  }

  /**
   * 用学号查询
   * @param sid 学号
   * @return
   */
  @GetMapping("selectStudentBySid")
  @ResponseBody
  public List<StudentDO> selectStudentBySid(@RequestParam String sid) {
    return studentService.selectStudentBySid(sid);
  }

  /**
   * 根据学号删除学生
   * @param sid 学号
   * @return
   */
  @GetMapping("deleteStudentBySid")
  @ResponseBody
  public int deleteStudentBySid(@RequestParam String sid) {
    return studentService.deleteStudentBySid(sid);
  }

  /**
   * 根据学号更新学生
   * @param sid 学号
   * @return
   */
  @GetMapping("updateStudentBySid")
  @ResponseBody
  public int updateStudentBySid(@RequestParam String sid, @RequestParam String name, @RequestParam String sex, @RequestParam String university, @RequestParam String college, @RequestParam String major, @RequestParam String sClass) {
    return studentService.updateStudentBySid(sid, name, sex, university, college, major, sClass);
  }

    /**
     * 根据学号更新学生
     * @param sid 学号
     * @return
     */
    @GetMapping("insertStudent")
    @ResponseBody
    public int insertStudent(@RequestParam String sid, @RequestParam String name, @RequestParam String sex, @RequestParam String university, @RequestParam String college, @RequestParam String major, @RequestParam String sClass) {
        return studentService.insertStudent(sid, name, sex, university, college, major, sClass);
    }


}
