package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.CommodityWithMyTime;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CommodityDetailController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/commodity/detail")
    public String queryCommodityById(HttpServletRequest httpServletRequest, HttpSession httpSession,ModelAndView modelAndView){
        Integer commodityId = Integer.valueOf(httpServletRequest.getParameter("commodityId"));
        CommodityWithMyTime commodity = commodityService.findCommodityByCommodityId(commodityId);
        httpSession.setAttribute("commodity",commodity);
        return "easyCommodityDetail";
    }
}
