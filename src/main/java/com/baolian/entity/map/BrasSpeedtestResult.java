package com.baolian.entity.map;

import java.io.Serializable;

/**
 * BRAS下载测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/2 21:15.
 */
public class BrasSpeedtestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //speed
    private Double speed;
    //qoe
    private Double qoe;
    //BRAS
    private String brasName;
    //日期
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    public String getBrasName() {
        return brasName;
    }

    public void setBrasName(String brasName) {
        this.brasName = brasName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BrasSpeedtestResult{" +
                "id=" + id +
                ", speed=" + speed +
                ", qoe=" + qoe +
                ", brasName='" + brasName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
