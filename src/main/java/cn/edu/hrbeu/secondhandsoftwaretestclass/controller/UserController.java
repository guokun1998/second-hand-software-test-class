package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/myInformation")
    public String userInformationHTML(){
        return "myInformation";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user1 , HttpSession session){

        User user=(User)session.getAttribute("user");

        user1.setUserPower(user.getUserPower());
        user1.setUserId(user.getUserId());

        User repeatUser = userService.findUserByPhoneNumber(user1.getUserPhoneNumber());



        if (repeatUser != null && repeatUser.getUserId() != user1.getUserId()){
            //占用了已存在的别人的手机号
            String message = "该手机号已被别人占用";
            session.setAttribute("message",message);
            return "redirect:fail";
        }


        userService.updateUserByUserId(user1);
        session.setAttribute("user",user1);
        return "redirect:myInformation";

    }
}
