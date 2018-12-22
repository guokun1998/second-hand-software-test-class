package cn.edu.hrbeu.secondhandsoftwaretestclass.service;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.CommodityWithMyTime;
import cn.edu.hrbeu.secondhandsoftwaretestclass.mapper.CommodityMapper;
import cn.edu.hrbeu.secondhandsoftwaretestclass.util.CommodityToCommodityWithMyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    public void insertCommidity(Commodity commodity){
        commodityMapper.insertCommodity(commodity);
    }

    public void deleteCommodity(Commodity commodity){
        commodityMapper.deleteCommodity(commodity);
    }

    public void updateCommodity(Commodity commodity){
        commodityMapper.updateCommodity(commodity);
    }


    public List<CommodityWithMyTime> findCommodityByCommodityNameBlured(Commodity commodity){

        return CommodityToCommodityWithMyTime.commodityToCommodityWithMyTime(commodityMapper.findCommodityByCommodityNameBlured(commodity));
    }


    public List<CommodityWithMyTime> find9FirstCommodity(){
        List<Commodity> commodityList = commodityMapper.find9FirstCommodity();

        return CommodityToCommodityWithMyTime.commodityToCommodityWithMyTime(commodityList);
    }

    public CommodityWithMyTime findCommodityByCommodityId(Integer commodityId){
        return CommodityToCommodityWithMyTime.commodityToCommodityWithMyTime(commodityMapper.findCommodityByCommodityId(commodityId));
    }



    public List<CommodityWithMyTime> findCommodityByUserId(Integer userId){
        return CommodityToCommodityWithMyTime.commodityToCommodityWithMyTime(commodityMapper.findCommodityByUserId(userId));
    }
}