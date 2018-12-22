package cn.edu.hrbeu.secondhandsoftwaretestclass.mapper;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityMapper {

    @Select("INSERT INTO " +
            "commodity(commodity_name,commodity_price,commodity_time,commodity_deadline,commodity_kind,commodity_detail,contact_way,user_id) " +
            "VALUE(#{commodityName},#{commodityPrice},#{commodityTime},#{commodityDeadline},#{commodityKind},#{commodityDetail},#{contactWay},#{userId})")
    public void insertCommodity(Commodity commodity);

    @Select("DELETE FROM commodity " +
            "WHERE commodity_id=#{commodityId}")
    public void deleteCommodity(Commodity commodity);

    @Select("UPDATE commodity " +
            "SET commodity_name=#{commodityName},commodity_price=#{commodityPrice},commodity_kind=#{commodityKind},commodity_detail=#{commodityDetail},contact_way=#{contactWay} " +
            "WHERE commodity_id=#{commodityId}")
    public void updateCommodity(Commodity commodity);


    @Select("SELECT * FROM commodity " +
            "WHERE commodity_name LIKE '%${commodityName}%'")
    public List<Commodity> findCommodityByCommodityNameBlured(Commodity commodity);

    @Select("SELECT * FROM commodity " +
            "WHERE user_id=#{userId}")
    public List<Commodity> findCommodityByUserId(Integer userId);


    @Select("SELECT * FROM commodity LIMIT 9")
    public List<Commodity> find9FirstCommodity();

    @Select("SELECT * FROM commodity " +
            "WHERE commodity_id=#{commodityId}")
    public Commodity findCommodityByCommodityId(Integer commodityId);
}
