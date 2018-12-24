package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdministratorController {

    @Autowired
    UserService userService;

    @RequestMapping("/administrator")
    public String administratorHTML(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null || user.getUserPower() != 2){
            String message = "非法操作";
            session.setAttribute("message",message);
            return "fail";
        }
        return "administrator";
    }

    @RequestMapping("/administrator/ban")
    public String  banUser(User user){
        user.setUserPower(0);
        userService.updateUserPowerByUserId(user);
        return "success";
    }

    @RequestMapping("/administrator/unblock")
    public String  unblockUser(User user){
        user.setUserPower(1);
        userService.updateUserPowerByUserId(user);
        return "success";
    }

    @RequestMapping("/administrator/warrant")
    public String  warrantUser(User user){
        user.setUserPower(2);
        userService.updateUserPowerByUserId(user);
        return "success";
    }
}
