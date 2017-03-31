package com.baolian.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 探针信息表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public class TestagentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //测试代理机ID，自动递增
    private Integer id;
    //测试代理机的别名标识
    private String name;
    //接入公网的IP
    private String ip;
    //
    private Double bandwidth;
    //地市（自动获取）
    private String city;
    //地市
    private String cityMan;
    //区县
    private String county;
    //用户唯一标识，由sysuuid加密后转换得到
    private String useruid;
    //测试机硬件唯一标识
    private String sysuuid;
    //测试机的归属地，如福州长乐区、福州市连江区，扩展此字段可针对不同归属地进行报表统计
    private String location;
    //测试机接入的归属运营商，如电信、移动，扩展此字段可针对不同归属运营商进行报表统计
    private String isp;
    //设备所属的接入网络所属层面,包含用户侧、接入侧、汇聚层、，四个字符串的枚举
    private String accesslayer;
    //接入方式类型，包含ADSL、EPON、GPON、FTTx+LAN、LAN、专线、CN2、汇聚层等字符串的枚举
    private String accesstype;
    //上联设备名称，如ADSL接入可填写已存在的汇聚层测试机的名称、也可填写不在此系统中的BRAS名称，可用于两个层面的用户感知指标对比、也可用于统计上一联设备如多个BRAS的用户感知指标对比
    private String uplink;
    //测试任务组编号
    private Integer testgroup;
    //测试任务组名
    private String testgroupName;
    //在线状态
    private String onlinestatus;
    //上线时间
    private Date onlineTime;
    //注册时间
    private Date registerTime;
    //硬件版本类型
    private String model;
    //设备型号
    private String device;
    //任务状态
    private String teststatus;
    //软件版本类型
    private String version;
    //任务间隔
    private Integer runInterval;
    //装机联系人
    private String contact;
    //装机地址
    private String address;
    //BRAS名称
    private String brasname;
    //BRAS_IP
    private String brasip;
    //BRAS端口
    private String brasport;
    //OLT名
    private String oltname;
    //OLT_IP
    private String oltip;
    //OLT端口
    private String oltport;
    //维护人电话
    private String phonenum;
    //健康度
    private Integer dayreport;

    /**
     * 设置：测试代理机ID，自动递增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：测试代理机ID，自动递增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：测试代理机的别名标识
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：测试代理机的别名标识
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：接入公网的IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取：接入公网的IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置：
     */
    public void setBandwidth(Double bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * 获取：
     */
    public Double getBandwidth() {
        return bandwidth;
    }

    /**
     * 设置：地市（自动获取）
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：地市（自动获取）
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置：地市
     */
    public void setCityMan(String cityMan) {
        this.cityMan = cityMan;
    }

    /**
     * 获取：地市
     */
    public String getCityMan() {
        return cityMan;
    }

    /**
     * 设置：区县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取：区县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置：用户唯一标识，由sysuuid加密后转换得到
     */
    public void setUseruid(String useruid) {
        this.useruid = useruid;
    }

    /**
     * 获取：用户唯一标识，由sysuuid加密后转换得到
     */
    public String getUseruid() {
        return useruid;
    }

    /**
     * 设置：测试机硬件唯一标识
     */
    public void setSysuuid(String sysuuid) {
        this.sysuuid = sysuuid;
    }

    /**
     * 获取：测试机硬件唯一标识
     */
    public String getSysuuid() {
        return sysuuid;
    }

    /**
     * 设置：测试机的归属地，如福州长乐区、福州市连江区，扩展此字段可针对不同归属地进行报表统计
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取：测试机的归属地，如福州长乐区、福州市连江区，扩展此字段可针对不同归属地进行报表统计
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置：测试机接入的归属运营商，如电信、移动，扩展此字段可针对不同归属运营商进行报表统计
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * 获取：测试机接入的归属运营商，如电信、移动，扩展此字段可针对不同归属运营商进行报表统计
     */
    public String getIsp() {
        return isp;
    }

    /**
     * 设置：设备所属的接入网络所属层面,包含用户侧、接入侧、汇聚层、，四个字符串的枚举
     */
    public void setAccesslayer(String accesslayer) {
        this.accesslayer = accesslayer;
    }

    /**
     * 获取：设备所属的接入网络所属层面,包含用户侧、接入侧、汇聚层、，四个字符串的枚举
     */
    public String getAccesslayer() {
        return accesslayer;
    }

    /**
     * 设置：接入方式类型，包含ADSL、EPON、GPON、FTTx+LAN、LAN、专线、CN2、汇聚层等字符串的枚举
     */
    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype;
    }

    /**
     * 获取：接入方式类型，包含ADSL、EPON、GPON、FTTx+LAN、LAN、专线、CN2、汇聚层等字符串的枚举
     */
    public String getAccesstype() {
        return accesstype;
    }

    /**
     * 设置：上联设备名称，如ADSL接入可填写已存在的汇聚层测试机的名称、也可填写不在此系统中的BRAS名称，可用于两个层面的用户感知指标对比、也可用于统计上一联设备如多个BRAS的用户感知指标对比
     */
    public void setUplink(String uplink) {
        this.uplink = uplink;
    }

    /**
     * 获取：上联设备名称，如ADSL接入可填写已存在的汇聚层测试机的名称、也可填写不在此系统中的BRAS名称，可用于两个层面的用户感知指标对比、也可用于统计上一联设备如多个BRAS的用户感知指标对比
     */
    public String getUplink() {
        return uplink;
    }

    /**
     * 设置：测试任务组编号
     */
    public void setTestgroup(Integer testgroup) {
        this.testgroup = testgroup;
    }

    /**
     * 获取：测试任务组编号
     */
    public Integer getTestgroup() {
        return testgroup;
    }

    /**
     * 设置：测试任务组名
     */
    public void setTestgroupName(String testgroupName) {
        this.testgroupName = testgroupName;
    }

    /**
     * 获取：测试任务组名
     */
    public String getTestgroupName() {
        return testgroupName;
    }

    /**
     * 设置：在线状态
     */
    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    /**
     * 获取：在线状态
     */
    public String getOnlinestatus() {
        return onlinestatus;
    }

    /**
     * 设置：上线时间
     */
    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    /**
     * 获取：上线时间
     */
    public Date getOnlineTime() {
        return onlineTime;
    }

    /**
     * 设置：注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取：注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置：硬件版本类型
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取：硬件版本类型
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置：设备型号
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * 获取：设备型号
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置：任务状态
     */
    public void setTeststatus(String teststatus) {
        this.teststatus = teststatus;
    }

    /**
     * 获取：任务状态
     */
    public String getTeststatus() {
        return teststatus;
    }

    /**
     * 设置：软件版本类型
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取：软件版本类型
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置：任务间隔
     */
    public void setRunInterval(Integer runInterval) {
        this.runInterval = runInterval;
    }

    /**
     * 获取：任务间隔
     */
    public Integer getRunInterval() {
        return runInterval;
    }

    /**
     * 设置：装机联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取：装机联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置：装机地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：装机地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：BRAS名称
     */
    public void setBrasname(String brasname) {
        this.brasname = brasname;
    }

    /**
     * 获取：BRAS名称
     */
    public String getBrasname() {
        return brasname;
    }

    /**
     * 设置：BRAS_IP
     */
    public void setBrasip(String brasip) {
        this.brasip = brasip;
    }

    /**
     * 获取：BRAS_IP
     */
    public String getBrasip() {
        return brasip;
    }

    /**
     * 设置：BRAS端口
     */
    public void setBrasport(String brasport) {
        this.brasport = brasport;
    }

    /**
     * 获取：BRAS端口
     */
    public String getBrasport() {
        return brasport;
    }

    /**
     * 设置：OLT名
     */
    public void setOltname(String oltname) {
        this.oltname = oltname;
    }

    /**
     * 获取：OLT名
     */
    public String getOltname() {
        return oltname;
    }

    /**
     * 设置：OLT_IP
     */
    public void setOltip(String oltip) {
        this.oltip = oltip;
    }

    /**
     * 获取：OLT_IP
     */
    public String getOltip() {
        return oltip;
    }

    /**
     * 设置：OLT端口
     */
    public void setOltport(String oltport) {
        this.oltport = oltport;
    }

    /**
     * 获取：OLT端口
     */
    public String getOltport() {
        return oltport;
    }

    /**
     * 设置：维护人电话
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * 获取：维护人电话
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * 设置：健康度
     */
    public void setDayreport(Integer dayreport) {
        this.dayreport = dayreport;
    }

    /**
     * 获取：健康度
     */
    public Integer getDayreport() {
        return dayreport;
    }
}
