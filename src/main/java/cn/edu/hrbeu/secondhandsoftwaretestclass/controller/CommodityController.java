package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.CommodityWithMyTime;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @RequestMapping("/queryCommodity/search")
    public String queryCommodity(HttpSession session,Commodity commodity){

        List<CommodityWithMyTime> commodityList = commodityService.findCommodityByCommodityNameBlured(commodity);
        session.setAttribute("commodityList", commodityList);
        return "easySearchResult";
    }

    @RequestMapping("/header")
    public String headerHTML(){
        return "header";
    }
}