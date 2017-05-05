package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Created by apple on 2017/5/2.
 */
public class CountyYoukutestResult implements Serializable, BaseResult {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //平均时延
    private Double speed;
    //最小时延
    private Double pausecount;
    //最大时延
    private Double pausetime;
    //丢包
    private Double qoe;
    //qoe
    private Double buffertime;
    //区县
    private String county;
    //日期
    private String date;

    public CountyYoukutestResult() {
    }

    public CountyYoukutestResult(String county, Integer id, Double speed, Double pausecount, Double pausetime, Double qoe, Double buffertime) {
        this.county = county;
        this.id = id;
        this.speed = speed;
        this.pausecount = pausecount;
        this.pausetime = pausetime;
        this.qoe = qoe;
        this.buffertime = buffertime;
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

    public Double getPausecount() {
        return pausecount;
    }

    public void setPausecount(Double pausecount) {
        this.pausecount = pausecount;
    }

    public Double getPausetime() {
        return pausetime;
    }

    public void setPausetime(Double pausetime) {
        this.pausetime = pausetime;
    }

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    public Double getBuffertime() {
        return buffertime;
    }

    public void setBuffertime(Double buffertime) {
        this.buffertime = buffertime;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CountyYoukutestResult{" +
                "id=" + id +
                ", speed=" + speed +
                ", pausecount=" + pausecount +
                ", pausetime=" + pausetime +
                ", qoe=" + qoe +
                ", buffertime=" + buffertime +
                ", county='" + county + '\'' +
                '}';
    }
}

