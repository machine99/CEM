package com.baolian.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 视频测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public class ResultYoukutestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //测试任务分组
    private String guid;
    //成功失败标记
    private Integer state;
    //失败原因
    private String errorcode;
    //destid
    private Integer destid;
    //测试目标
    private String destname;
    //测试时间
    private Date testtime;
    //测试机
    private String testagent;
    //qoe
    private Double qoe;
    //带宽
    private Double bandwidth;
    //下载速率
    private Double speed;
    //停顿次数
    private Double pausecount;
    //停顿时长
    private Double pausetime;
    //缓冲区大小
    private Double buffersize;
    //缓冲区占满时长
    private Double buffertime;
    //下载总流量
    private Double speedsize;
    //testagentid
    private Integer testagentid;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：测试任务分组
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 获取：测试任务分组
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
     * 设置：destid
     */
    public void setDestid(Integer destid) {
        this.destid = destid;
    }

    /**
     * 获取：destid
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
     * 设置：下载速率
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取：下载速率
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置：停顿次数
     */
    public void setPausecount(Double pausecount) {
        this.pausecount = pausecount;
    }

    /**
     * 获取：停顿次数
     */
    public Double getPausecount() {
        return pausecount;
    }

    /**
     * 设置：停顿时长
     */
    public void setPausetime(Double pausetime) {
        this.pausetime = pausetime;
    }

    /**
     * 获取：停顿时长
     */
    public Double getPausetime() {
        return pausetime;
    }

    /**
     * 设置：缓冲区大小
     */
    public void setBuffersize(Double buffersize) {
        this.buffersize = buffersize;
    }

    /**
     * 获取：缓冲区大小
     */
    public Double getBuffersize() {
        return buffersize;
    }

    /**
     * 设置：缓冲区占满时长
     */
    public void setBuffertime(Double buffertime) {
        this.buffertime = buffertime;
    }

    /**
     * 获取：缓冲区占满时长
     */
    public Double getBuffertime() {
        return buffertime;
    }

    /**
     * 设置：下载总流量
     */
    public void setSpeedsize(Double speedsize) {
        this.speedsize = speedsize;
    }

    /**
     * 获取：下载总流量
     */
    public Double getSpeedsize() {
        return speedsize;
    }

    /**
     * 设置：testagentid
     */
    public void setTestagentid(Integer testagentid) {
        this.testagentid = testagentid;
    }

    /**
     * 获取：testagentid
     */
    public Integer getTestagentid() {
        return testagentid;
    }
}
