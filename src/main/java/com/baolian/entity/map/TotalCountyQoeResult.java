package com.baolian.entity.map;

import java.io.Serializable;

/**
 * 区县平均qoe的bean类
 * Created by tomxie on 2017/5/3 20:58.
 */
public class TotalCountyQoeResult extends TotalBaseResult {

    //区县
    private String county;

    public TotalCountyQoeResult(String county) {
        super(null);
        this.county = county;
    }


    public TotalCountyQoeResult(String county, String date) {
        super(date);
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "TotalCountyQoeResult{" +
                "county='" + county + '\'' +
                ", pingAvgQoe=" + super.getPingAvgQoe() +
                ", httpAvgQoe=" + super.getHttpAvgQoe() +
                ", speedAvgQoe=" + super.getSpeedAvgQoe() +
                ", gameAvgQoe=" + super.getGameAvgQoe() +
                ", youkuAvgQoe=" + super.getYoukuAvgQoe() +
                ", date='" + super.getDate() + '\'' +
                '}';
    }
}
