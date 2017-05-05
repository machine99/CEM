package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Created by apple on 2017/5/1.
 */
public class CountySpeedtestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //speed
    private Double speed;
    //qoe
    private Double qoe;
    //区县
    private String county;
    //日期
    private String date;

    public CountySpeedtestResult(){

    }

    public CountySpeedtestResult(String county, Integer id, Double speed, Double qoe) {
        this.county = county;
        this.id = id;
        this.speed = speed;
        this.qoe = qoe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "CountySpeedtestResult{" +
                "id=" + id +
                ", speed=" + speed +
                ", qoe=" + qoe +
                ", county='" + county + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

