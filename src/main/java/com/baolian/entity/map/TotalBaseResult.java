package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Total结果的基类
 * Created by tomxie on 2017/5/9 9:04.
 */
public class TotalBaseResult implements Serializable, Timizable {
    private static final long serialVersionUID = 1L;

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

    public TotalBaseResult(String date) {
        this.date = date;
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

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s, %f, %f, %f, %f, %f", date, pingAvgQoe, httpAvgQoe, speedAvgQoe, gameAvgQoe, youkuAvgQoe);
    }
}
