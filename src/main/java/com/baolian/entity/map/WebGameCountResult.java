package com.baolian.entity.map;

/**
 * Created by yuanbaby on 2017/5/4.
 */
public class WebGameCountResult {
    private static final long serialVersionUID = 1L;
    //id
    private Integer id;
    //网址
    private String destname;
    //ping时延
    private Double rtt_avg;
    //qoe
    private Double qoe;
    //连接时延
    private Double tcpConnect;
    //丢包
    private Double loss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestname() {
        return destname;
    }

    public void setDestname(String destname) {
        this.destname = destname;
    }

    public Double getRtt_avg() {
        return rtt_avg;
    }

    public void setRtt_avg(Double rtt_avg) {
        this.rtt_avg = rtt_avg;
    }

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
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

    @Override
    public String toString() {
        return "WebGameCountResult{" +
                "id=" + id +
                ", destname='" + destname + '\'' +
                ", rtt_avg=" + rtt_avg +
                ", qoe=" + qoe +
                ", tcpConnect=" + tcpConnect +
                ", loss=" + loss +
                '}';
    }
}
