package com.baolian.entity.map;

/**
 * Created by yuanbaby on 2017/5/2.
 */
public class WebHttpCountResult {
    private static final long serialVersionUID = 1L;
    //id
    private Integer id;
    //门户网站
    private String destname;
    //qoe
    private Double qoe;
    //下载速率
    private Double speed;
    //DNS时延
    private Double dnsdelay;
    //连接时延
    private Double connectdelay;
    //响应时延
    private Double responsedelay;
    //下载时延
    private Double downloaddelay;

    public Double getDownloaddelay() {
        return downloaddelay;
    }

    public void setDownloaddelay(Double downloaddelay) {
        this.downloaddelay = downloaddelay;
    }

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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDnsdelay() {
        return dnsdelay;
    }

    public void setDnsdelay(Double dnsdelay) {
        this.dnsdelay = dnsdelay;
    }

    public Double getConnectdelay() {
        return connectdelay;
    }

    public void setConnectdelay(Double connectdelay) {
        this.connectdelay = connectdelay;
    }

    public Double getResponsedelay() {
        return responsedelay;
    }

    public void setResponsedelay(Double responsedelay) {
        this.responsedelay = responsedelay;
    }



    @Override
    public String toString() {
        return "WebHttpCountResult{" +
                "id=" + id +
                ", destname='" + destname + '\'' +
                ", qoe=" + qoe +
                ", speed=" + speed +
                ", dnsdelay=" + dnsdelay +
                ", connectdelay=" + connectdelay +
                ", responsedelay=" + responsedelay +
                ", downloaddelay=" + downloaddelay +
                '}';
    }

}
