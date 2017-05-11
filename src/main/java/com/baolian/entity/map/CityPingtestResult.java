package com.baolian.entity.map;

/**
 * 城市平均QoE
 * Created by tomxie on 2017/5/10 16:38.
 */
public class CityPingtestResult extends BaseResult {
    //城市
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %f, %s", getId(), getCity(), getQoe(), getDate());
    }
}
