package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Created by apple on 2017/4/24.
 */
public class CountyHttptestResult implements Serializable, BaseResult {
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
    //日期
    private String date;

    public CountyHttptestResult() {

    }

    public CountyHttptestResult(String county, Integer id, Double connectDelay, Double responseDelay, Double dnsDelay, Double speed, Double qoe) {
        this.county = county;
        this.id = id;
        this.connectDelay = connectDelay;
        this.responseDelay = responseDelay;
        this.dnsDelay = dnsDelay;
        this.speed = speed;
        this.qoe = qoe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getConnectDelay() {
        return connectDelay;
    }

    public void setConnectDelay(Double connectDelay) {
        this.connectDelay = connectDelay;
    }

    public Double getDnsDelay() {
        return dnsDelay;
    }

    public void setDnsDelay(Double dnsDelay) {
        this.dnsDelay = dnsDelay;
    }

    public Double getResponseDelay() {
        return responseDelay;
    }

    public void setResponseDelay(Double responseDelay) {
        this.responseDelay = responseDelay;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CountyHttptestResult{" +
                "id=" + id +
                ", connectDelay=" + connectDelay +
                ", dnsDelay=" + dnsDelay +
                ", responseDelay=" + responseDelay +
                ", speed=" + speed +
                ", qoe=" + qoe +
                ", date='" + date + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
