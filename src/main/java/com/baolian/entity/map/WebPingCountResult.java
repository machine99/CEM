package com.baolian.entity.map;

/**
 * Created by yuanbaby on 2017/5/2.
 */
public class WebPingCountResult {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //门户地址
    private String destname;
    //qoe
    private Double qoe;
    //rtt_avg
    private Double rtt_avg;
    //最小时延
    private Double rtt_min;
    //最大时延
    private Double rtt_max;
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

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    public Double getRtt_avg() {
        return rtt_avg;
    }

    public void setRtt_avg(Double rtt_avg) {
        this.rtt_avg = rtt_avg;
    }

    public Double getRtt_min() {
        return rtt_min;
    }

    public void setRtt_min(Double rtt_min) {
        this.rtt_min = rtt_min;
    }

    public Double getRtt_max() {
        return rtt_max;
    }

    public void setRtt_max(Double rtt_max) {
        this.rtt_max = rtt_max;
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        this.loss = loss;
    }

    @Override
    public String toString() {
        return "WebPingCountResult{" +
                "id=" + id +
                ", destname='" + destname + '\'' +
                ", qoe=" + qoe +
                ", rtt_avg=" + rtt_avg +
                ", rtt_min=" + rtt_min +
                ", rtt_max=" + rtt_max +
                ", loss=" + loss +
                '}';
    }
}
