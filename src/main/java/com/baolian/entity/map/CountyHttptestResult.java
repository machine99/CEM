package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Created by apple on 2017/4/24.
 */
public class CountyHttptestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //平均时延
    private Double connectDelay;
    //最小时延
    private Double dnsDelay;
    //最大时延
    private Double responseDelay;
    //丢包
    private Double speed;
    //qoe
    private Double qoe;



    //区县
    private String county;

    public CountyHttptestResult(){

    }

    public CountyHttptestResult(String county, Integer id, Double connectDelay, Double responseDelay, Double dnsDelay, Double speed, Double qoe){
        this.county = county;
        this.id = id;
        this.connectDelay = connectDelay;
        this.responseDelay = responseDelay;
        this.dnsDelay = dnsDelay;
        this.speed = speed;
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

    public Double getconnectDelay() {
        return connectDelay;
    }

    public void setconnectDelay(Double connectDelay) {
        this.connectDelay = connectDelay;
    }

    public Double getdnsDelay() {
        return dnsDelay;
    }

    public void setdnsDelay(Double dnsDelay) {
        this.dnsDelay = dnsDelay;
    }

    public Double getresponseDelay() {
        return responseDelay;
    }

    public void setresponseDelay(Double responseDelay) {
        this.responseDelay = responseDelay;
    }

    public Double getspeed() {
        return speed;
    }

    public void setspeed(Double speed) {
        this.speed = speed;
    }

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    @Override
    public String toString() {
        return String.format("%d,%f,%f,%f,%f,%f,%s", id, connectDelay, dnsDelay, responseDelay, speed, qoe, county);
    }
}
