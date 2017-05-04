package com.baolian.entity.map;

import java.io.Serializable;

/**
 * BRAS游戏测试返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/2 14:25.
 */
public class BrasGametestResult implements Serializable {
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
        return "BrasGametestResult{" +
                "id=" + id +
                ", rtt_avg=" + rtt_avg +
                ", tcpConnect=" + tcpConnect +
                ", loss=" + loss +
                ", qoe=" + qoe +
                ", brasName='" + brasName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
