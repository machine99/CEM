package com.baolian.entity.map;

import java.io.Serializable;

/**
 * BRAS网页测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/2 10:55.
 */
public class BrasHttptestResult implements Serializable{
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //DNS时延
    private Double dnsDelay;
    //TCP时延
    private Double connectDelay;
    //服务器时延
    private Double responseDelay;
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

    public Double getDnsDelay() {
        return dnsDelay;
    }

    public void setDnsDelay(Double dnsDelay) {
        this.dnsDelay = dnsDelay;
    }

    public Double getConnectDelay() {
        return connectDelay;
    }

    public void setConnectDelay(Double connectDelay) {
        this.connectDelay = connectDelay;
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
        return "BrasHttptestResult{" +
                "id=" + id +
                ", dnsDelay=" + dnsDelay +
                ", connectDelay=" + connectDelay +
                ", responseDelay=" + responseDelay +
                ", speed=" + speed +
                ", qoe=" + qoe +
                ", brasName='" + brasName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
