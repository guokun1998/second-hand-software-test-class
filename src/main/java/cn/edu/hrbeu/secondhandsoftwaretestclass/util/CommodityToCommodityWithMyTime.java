package cn.edu.hrbeu.secondhandsoftwaretestclass.util;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.CommodityWithMyTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommodityToCommodityWithMyTime {
    public static ArrayList<CommodityWithMyTime> commodityToCommodityWithMyTime(List<Commodity> commodityList){
        ArrayList<CommodityWithMyTime> commodityWithMyTimeList = new ArrayList<>();
        for (Commodity commodity:commodityList) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String timeString = formatter.format(commodity.getCommodityTime());
            String deadlineString = null;
            if (commodity.getCommodityDeadline() != null){

                deadlineString = formatter.format(commodity.getCommodityDeadline());
            }
            CommodityWithMyTime commodity1 = new CommodityWithMyTime();
            commodity1.setMyCommodityDeadline(deadlineString);
            commodity1.setMyCommodityTime(timeString);

            commodity1.setCommodityDetail(commodity.getCommodityDetail());
            commodity1.setCommodityId(commodity.getCommodityId());
            commodity1.setCommodityKind(commodity.getCommodityKind());
            commodity1.setCommodityName(commodity.getCommodityName());
            commodity1.setCommodityPicture(commodity.getCommodityPicture());
            commodity1.setCommodityPrice(commodity.getCommodityPrice());
            commodity1.setContactWay(commodity.getContactWay());
            commodity1.setUserId(commodity.getUserId());

            commodityWithMyTimeList.add(commodity1);
        }
        return commodityWithMyTimeList;
    }
    public static CommodityWithMyTime commodityToCommodityWithMyTime(Commodity commodity){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String timeString = formatter.format(commodity.getCommodityTime());
        String deadlineString = null;
        if (commodity.getCommodityDeadline() != null){

            deadlineString = formatter.format(commodity.getCommodityDeadline());
        }
        CommodityWithMyTime commodity1 = new CommodityWithMyTime();
        commodity1.setMyCommodityDeadline(deadlineString);
        commodity1.setMyCommodityTime(timeString);

        commodity1.setCommodityDetail(commodity.getCommodityDetail());
        commodity1.setCommodityId(commodity.getCommodityId());
        commodity1.setCommodityKind(commodity.getCommodityKind());
        commodity1.setCommodityName(commodity.getCommodityName());
        commodity1.setCommodityPicture(commodity.getCommodityPicture());
        commodity1.setCommodityPrice(commodity.getCommodityPrice());
        commodity1.setContactWay(commodity.getContactWay());
        commodity1.setUserId(commodity.getUserId());

        return commodity1;
    }
}
