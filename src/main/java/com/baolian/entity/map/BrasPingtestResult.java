package com.baolian.entity.map;

import java.io.Serializable;

/**
 * BRASPing测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/2 9:18.
 */
public class BrasPingtestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //平均时延
    private Double rttAvg;
    //最小时延
    private Double rttMin;
    //最大时延
    private Double rttMax;
    //丢包
    private Double loss;
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

    public Double getRttAvg() {
        return rttAvg;
    }

    public void setRttAvg(Double rttAvg) {
        this.rttAvg = rttAvg;
    }

    public Double getRttMin() {
        return rttMin;
    }

    public void setRttMin(Double rttMin) {
        this.rttMin = rttMin;
    }

    public Double getRttMax() {
        return rttMax;
    }

    public void setRttMax(Double rttMax) {
        this.rttMax = rttMax;
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        this.loss = loss;
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
        return "BrasPingtestResult{" +
                "id=" + id +
                ", rttAvg=" + rttAvg +
                ", rttMin=" + rttMin +
                ", rttMax=" + rttMax +
                ", loss=" + loss +
                ", qoe=" + qoe +
                ", brasName='" + brasName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
