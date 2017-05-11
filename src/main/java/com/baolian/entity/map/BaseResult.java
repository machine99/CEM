package com.baolian.entity.map;

import java.io.Serializable;

/**
 * Result的基础类
 * Created by tomxie on 2017/5/4 22:26.
 */
public class BaseResult implements Serializable, Timizable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //qoe
    private Double qoe;
    //日期
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQoe() {
        return qoe;
    }

    public void setQoe(Double qoe) {
        this.qoe = qoe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
