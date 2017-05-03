package com.baolian.entity.map;

/**
 * Created by yuanbaby on 2017/5/3.
 */
public class WebVideoCountResult {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //门户地址
    private String destname;
    //下载速率
    private Double speed;
    //qoe
    private Double qoe;
    //停顿次数
    private Double pausecount;
    //停顿时长
    private Double pausetime;
    //缓冲区占满时长
    private Double buffertime;

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

    public Double getPausecount() {
        return pausecount;
    }

    public void setPausecount(Double pausecount) {
        this.pausecount = pausecount;
    }

    public Double getPausetime() {
        return pausetime;
    }

    public void setPausetime(Double pausetime) {
        this.pausetime = pausetime;
    }

    public Double getBuffertime() {
        return buffertime;
    }

    public void setBuffertime(Double buffertime) {
        this.buffertime = buffertime;
    }

    @Override
    public String toString() {
        return "WebVideoCountResult{" +
                "id=" + id +
                ", destname='" + destname + '\'' +
                ", speed=" + speed +
                ", qoe=" + qoe +
                ", pausecount=" + pausecount +
                ", pausetime=" + pausetime +
                ", buffertime=" + buffertime +
                '}';
    }
}
