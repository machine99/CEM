package com.baolian.entity.map;

import java.io.Serializable;

/**
 * 区县平均qoe的bean类
 * Created by tomxie on 2017/5/3 20:58.
 */
public class TotalCountyQoeResult implements Serializable, BaseResult {
    private static final long serialVersionUID = 1L;

    //BRAS
    private String county;
    //ping感知平均qoe
    private Double pingAvgQoe;
    //网页感知平均qoe
    private Double httpAvgQoe;
    //下载感知平均qoe
    private Double speedAvgQoe;
    //游戏感知平均qoe
    private Double gameAvgQoe;
    //视频感知平均qoe
    private Double youkuAvgQoe;
    // 日期
    private String date;

    public TotalCountyQoeResult(String county) {
        this.county = county;
    }


    public TotalCountyQoeResult(String county, String date) {
        this.county = county;
        this.date = date;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Double getPingAvgQoe() {
        return pingAvgQoe;
    }

    public void setPingAvgQoe(Double pingAvgQoe) {
        this.pingAvgQoe = pingAvgQoe;
    }

    public Double getHttpAvgQoe() {
        return httpAvgQoe;
    }

    public void setHttpAvgQoe(Double httpAvgQoe) {
        this.httpAvgQoe = httpAvgQoe;
    }

    public Double getSpeedAvgQoe() {
        return speedAvgQoe;
    }

    public void setSpeedAvgQoe(Double speedAvgQoe) {
        this.speedAvgQoe = speedAvgQoe;
    }

    public Double getGameAvgQoe() {
        return gameAvgQoe;
    }

    public void setGameAvgQoe(Double gameAvgQoe) {
        this.gameAvgQoe = gameAvgQoe;
    }

    public Double getYoukuAvgQoe() {
        return youkuAvgQoe;
    }

    public void setYoukuAvgQoe(Double youkuAvgQoe) {
        this.youkuAvgQoe = youkuAvgQoe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TotalCountyQoeResult{" +
                "county='" + county + '\'' +
                ", pingAvgQoe=" + pingAvgQoe +
                ", httpAvgQoe=" + httpAvgQoe +
                ", speedAvgQoe=" + speedAvgQoe +
                ", gameAvgQoe=" + gameAvgQoe +
                ", youkuAvgQoe=" + youkuAvgQoe +
                ", date='" + date + '\'' +
                '}';
    }
}
