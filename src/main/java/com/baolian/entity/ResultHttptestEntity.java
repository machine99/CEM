package com.baolian.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 网页测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public class ResultHttptestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //测试任务组
    private String guid;
    //成功失败标记
    private Integer state;
    //失败原因
    private String errorcode;
    //任务ID
    private Integer destid;
    //测试目标
    private String destname;
    //目标IP
    private String destip;
    //测试时间
    private Date testtime;
    //总时延
    private Double alldelay;
    //首屏时延
    private Double screendelay;
    //测试机
    private String testagent;
    //qoe
    private Double qoe;
    //带宽
    private Double bandwidth;
    //HTTP下载速率
    private Double speed;
    //DNS时延
    private Double dnsdelay;
    //连接时延
    private Double connectdelay;
    //响应时延
    private Double responsedelay;
    //下载时延
    private Double downloaddelay;
    //下载字节
    private Double httpsize;
    //http状态码
    private Integer httpstatus;
    //探针ID
    private Integer testagentid;

    /**
     * 设置：id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：测试任务组
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 获取：测试任务组
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 设置：成功失败标记
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取：成功失败标记
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置：失败原因
     */
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    /**
     * 获取：失败原因
     */
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * 设置：任务ID
     */
    public void setDestid(Integer destid) {
        this.destid = destid;
    }

    /**
     * 获取：任务ID
     */
    public Integer getDestid() {
        return destid;
    }

    /**
     * 设置：测试目标
     */
    public void setDestname(String destname) {
        this.destname = destname;
    }

    /**
     * 获取：测试目标
     */
    public String getDestname() {
        return destname;
    }

    /**
     * 设置：目标IP
     */
    public void setDestip(String destip) {
        this.destip = destip;
    }

    /**
     * 获取：目标IP
     */
    public String getDestip() {
        return destip;
    }

    /**
     * 设置：测试时间
     */
    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    /**
     * 获取：测试时间
     */
    public Date getTesttime() {
        return testtime;
    }

    /**
     * 设置：总时延
     */
    public void setAlldelay(Double alldelay) {
        this.alldelay = alldelay;
    }

    /**
     * 获取：总时延
     */
    public Double getAlldelay() {
        return alldelay;
    }

    /**
     * 设置：首屏时延
     */
    public void setScreendelay(Double screendelay) {
        this.screendelay = screendelay;
    }

    /**
     * 获取：首屏时延
     */
    public Double getScreendelay() {
        return screendelay;
    }

    /**
     * 设置：测试机
     */
    public void setTestagent(String testagent) {
        this.testagent = testagent;
    }

    /**
     * 获取：测试机
     */
    public String getTestagent() {
        return testagent;
    }

    /**
     * 设置：qoe
     */
    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    /**
     * 获取：qoe
     */
    public Double getQoe() {
        return qoe;
    }

    /**
     * 设置：带宽
     */
    public void setBandwidth(Double bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * 获取：带宽
     */
    public Double getBandwidth() {
        return bandwidth;
    }

    /**
     * 设置：HTTP下载速率
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取：HTTP下载速率
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置：DNS时延
     */
    public void setDnsdelay(Double dnsdelay) {
        this.dnsdelay = dnsdelay;
    }

    /**
     * 获取：DNS时延
     */
    public Double getDnsdelay() {
        return dnsdelay;
    }

    /**
     * 设置：连接时延
     */
    public void setConnectdelay(Double connectdelay) {
        this.connectdelay = connectdelay;
    }

    /**
     * 获取：连接时延
     */
    public Double getConnectdelay() {
        return connectdelay;
    }

    /**
     * 设置：响应时延
     */
    public void setResponsedelay(Double responsedelay) {
        this.responsedelay = responsedelay;
    }

    /**
     * 获取：响应时延
     */
    public Double getResponsedelay() {
        return responsedelay;
    }

    /**
     * 设置：下载时延
     */
    public void setDownloaddelay(Double downloaddelay) {
        this.downloaddelay = downloaddelay;
    }

    /**
     * 获取：下载时延
     */
    public Double getDownloaddelay() {
        return downloaddelay;
    }

    /**
     * 设置：下载字节
     */
    public void setHttpsize(Double httpsize) {
        this.httpsize = httpsize;
    }

    /**
     * 获取：下载字节
     */
    public Double getHttpsize() {
        return httpsize;
    }

    /**
     * 设置：http状态码
     */
    public void setHttpstatus(Integer httpstatus) {
        this.httpstatus = httpstatus;
    }

    /**
     * 获取：http状态码
     */
    public Integer getHttpstatus() {
        return httpstatus;
    }

    /**
     * 设置：探针ID
     */
    public void setTestagentid(Integer testagentid) {
        this.testagentid = testagentid;
    }

    /**
     * 获取：探针ID
     */
    public Integer getTestagentid() {
        return testagentid;
    }
}
