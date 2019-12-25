
package top.warmj.ea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("Test")
    public String Test(){
        return "Test";
    }

    @RequestMapping("left.html")
    public String Left(){
        return "left";
    }

    @RequestMapping("right.html")
    public String Right(){
        return "right";
    }

    @RequestMapping("header.html")
    public String Header(){
        return "header";
    }

    @RequestMapping("studentEdit.html")
    public String StudentEdit(){
        return "studentEdit";
    }

    @RequestMapping("/subs/sub1-1.html")
    public String Sub1_1(){
        return "/subs/sub1-1";
    }

    @RequestMapping("/subs/sub1-2.html")
    public String Sub1_2(){
        return "/subs/sub1-2";
    }
}