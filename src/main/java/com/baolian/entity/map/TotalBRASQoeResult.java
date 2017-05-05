package com.baolian.entity.map;

import java.io.Serializable;
import java.util.Objects;

/**
 * BRAS平均qoe的bean类
 * Created by tomxie on 2017/5/3 20:58.
 */
public class TotalBRASQoeResult implements Serializable, BaseResult {
    private static final long serialVersionUID = 1L;

    //BRAS
    private String brasName;
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

    public TotalBRASQoeResult(String brasName) {
        this.brasName = brasName;
    }


    public TotalBRASQoeResult(String brasName, String date) {
        this.brasName = brasName;
        this.date = date;
    }

    public String getBrasName() {
        return brasName;
    }

    public void setBrasName(String brasName) {
        this.brasName = brasName;
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
        return String.format("%s,%f,%f,%f,%f,%f,%s", brasName, pingAvgQoe, httpAvgQoe, speedAvgQoe, gameAvgQoe, youkuAvgQoe, date);
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == this) {
    //         return true;
    //     }
    //     if (obj instanceof TotalBRASQoeResult) {
    //         return this.brasName.equals(((TotalBRASQoeResult) obj).getBrasName());
    //     }
    //     return false;
    // }
}
