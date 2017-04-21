package com.baolian.entity.map;

import java.io.Serializable;

/**
 * 区域Ping测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/4/20 10:31.
 */
public class CountyPingtestResult implements Serializable {
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



    //区县
    private String county;

    public CountyPingtestResult(){

    }

    public CountyPingtestResult(String county, Integer id, Double rttAvg, Double rttMax, Double rttMin, Double loss, Double qoe){
        this.county = county;
        this.id = id;
        this.rttAvg = rttAvg;
        this.rttMax = rttMax;
        this.rttMin = rttMin;
        this.loss = loss;
        this.qoe = qoe;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

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

    @Override
    public String toString() {
        return String.format("%d,%f,%f,%f,%f,%f,%s", id, rttAvg, rttMin, rttMax, loss, qoe, county);
    }
}
