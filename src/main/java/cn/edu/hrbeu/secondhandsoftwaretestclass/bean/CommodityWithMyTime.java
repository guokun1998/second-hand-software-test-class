package cn.edu.hrbeu.secondhandsoftwaretestclass.bean;

public class CommodityWithMyTime extends Commodity{
    private String myCommodityTime;
    private String myCommodityDeadline;

    public String getMyCommodityTime() {
        return myCommodityTime;
    }

    public void setMyCommodityTime(String myCommodityTime) {
        this.myCommodityTime = myCommodityTime;
    }

    public String getMyCommodityDeadline() {
        return myCommodityDeadline;
    }

    public void setMyCommodityDeadline(String myCommodityDeadline) {
        this.myCommodityDeadline = myCommodityDeadline;
    }
}
