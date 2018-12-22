package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.CommodityWithMyTime;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyCommodityController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/myCommodity")
    public String myCommodityHTML(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            //未登录
            return "fail";
        }
        List<CommodityWithMyTime> commodityList = commodityService.findCommodityByUserId(user.getUserId());
        session.setAttribute("commodityList",commodityList);
        return "myCommodity";
    }

}
