package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String loginHtml(){
        return "login";
    }

    @PostMapping("/login/try")
    public String login(User user, HttpSession session){
        User user1 = userService.findUserByStudentIdAndPassword(user);
        if (user1 == null){
            String message = "学号或密码错误";
            session.setAttribute("message",message);
            return "fail";
        }
        else {
            if (user1.getUserPower() == 0){
                String message = "该账户已被封禁，请联系管理员解封";
                session.setAttribute("message",message);
                return "fail";
            }
            else {
                session.setAttribute("user",user1);

            }

            return "redirect:/";
        }
    }
}
