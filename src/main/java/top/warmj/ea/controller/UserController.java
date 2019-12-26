package top.warmj.ea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.warmj.ea.domain.UserDO;
import top.warmj.ea.services.UserService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询密码
     * @return
     */
    @GetMapping("selectUser")
    @ResponseBody
    public List<UserDO> selectStudentBySid(@RequestParam String username, @RequestParam String password) {
        return userService.selectUser(username, password);
    }

}
