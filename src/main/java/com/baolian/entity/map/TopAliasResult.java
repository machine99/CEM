package com.baolian.entity.map;

/**
 * 首页网页Top返回结果对应类，用于resultMap
 * Created by tomxie on 2017/5/8 9:49.
 */
public class TopAliasResult extends BaseResult {
    private static final long serialVersionUID = 1L;

    // id
    private Integer id;
    // 网址
    private String destName;
    // 网站名
    private String alias;
    // 平均qoe
    private Double qoe;
    // 时间
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
