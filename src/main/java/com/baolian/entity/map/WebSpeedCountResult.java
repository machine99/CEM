package com.baolian.entity.map;

/**
 * Created by yuanbaby on 2017/5/3.
 */
public class WebSpeedCountResult {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //网站
    private String destname;
    //速率
    private Double speed;
    //qoe
    private Double qoe;

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

    @Override
    public String toString() {
        return "WebSpeedCountResult{" +
                "id=" + id +
                ", destname='" + destname + '\'' +
                ", speed=" + speed +
                ", qoe=" + qoe +
                '}';
    }
}
