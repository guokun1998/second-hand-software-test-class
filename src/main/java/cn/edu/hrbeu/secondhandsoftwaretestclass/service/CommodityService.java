package cn.edu.hrbeu.secondhandsoftwaretestclass.service;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<Commodity> findCommodity(Commodity commodity){
        List<Commodity> commodityList = commodityMapper.findCommodity(commodity);
//        for(Commodity temp:commodityList){
//
//        }
        return commodityList;
    }


    public List<Commodity> find9FirstCommodity(){
        return commodityMapper.find9FirstCommodity();
    }

    public Commodity findCommodityByCommodityId(Integer commodityId){
        return commodityMapper.findCommodityByCommodityId(commodityId);
    }



    public List<Commodity> findCommodityByUserId(Integer userId){
        return commodityMapper.findCommodityByUserId(userId);
    }
}