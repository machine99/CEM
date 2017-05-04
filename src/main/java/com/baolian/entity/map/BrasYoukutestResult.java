package com.baolian.entity.map;

import java.io.Serializable;

/**
 * BRAS视频测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/2 15:16.
 */
public class BrasYoukutestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //停顿次数
    private Double pauseCount;
    //停顿时长
    private Double pauseTime;
    //缓冲时长
    private Double bufferTime;
    //速率
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

    public Double getPauseCount() {
        return pauseCount;
    }

    public void setPauseCount(Double pauseCount) {
        this.pauseCount = pauseCount;
    }

    public Double getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(Double pauseTime) {
        this.pauseTime = pauseTime;
    }

    public Double getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(Double bufferTime) {
        this.bufferTime = bufferTime;
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
        return String.format("%d,%f,%f,%f,%f,%f,%s", id, pauseCount, pauseTime, bufferTime, speed, qoe, brasName);
    }
}
