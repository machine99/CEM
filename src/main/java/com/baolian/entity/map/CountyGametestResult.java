package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Created by apple on 2017/4/27.
 */
public class CountyGametestResult implements Serializable, BaseResult {

    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //ping时延
    private Double rtt_avg;
    //连接时延
    private Double tcpConnect;
    //丢包
    private Double loss;
    //qoe
    private Double qoe;
    //区县
    private String county;
    //日期
    private String date;

    public CountyGametestResult() {

    }

    public CountyGametestResult(String county, Integer id, Double rtt_avg, Double tcpConnect, Double loss, Double qoe) {
        this.county = county;
        this.id = id;
        this.rtt_avg = rtt_avg;
        this.tcpConnect = tcpConnect;
        this.loss = loss;
        this.qoe = qoe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRtt_avg() {
        return rtt_avg;
    }

    public void setRtt_avg(Double rtt_avg) {
        this.rtt_avg = rtt_avg;
    }

    public Double getTcpConnect() {
        return tcpConnect;
    }

    public void setTcpConnect(Double tcpConnect) {
        this.tcpConnect = tcpConnect;
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
        return "CountyGametestResult{" +
                "id=" + id +
                ", rtt_avg=" + rtt_avg +
                ", tcpConnect=" + tcpConnect +
                ", loss=" + loss +
                ", qoe=" + qoe +
                ", county='" + county + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
