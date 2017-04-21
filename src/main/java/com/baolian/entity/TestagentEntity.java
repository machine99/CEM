package com.baolian.entity;

import com.baolian.utils.excel.annotation.ExcelIgnore;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public class TestagentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //id, 含有ExcelIgnore注解, 不被导出到Excel
    @ExcelIgnore
    private Long id;
    //测试机名
    private String name;
    //IP地址
    private String ip;
    //vpnip
    private String vpnip;
    //dnsip
    private String dnsip;
    //带宽
    private Double bandwidth;
    //地市自动
    private String city;
    //地市
    private String cityMan;
    //区县
    private String county;
    //软件标识
    private String useruid;
    //硬件编码
    private String sysuuid;
    //归属地
    private String location;
    //运营商自动
    private String isp;
    //网络类型
    private String networktype;
    //网络层次
    private String accesslayer;
    //运营商
    private String ispMan;
    //接入类型
    private String accesstype;
    //上联BRAS
    private String uplink;
    //测试任务ID
    private Integer testgroup;
    //测试任务组
    private String testgroupName;
    //在线状态
    private String onlinestatus;
    //在线时间
    private Date onlineTime;
    //
    private Date registerTime;
    //探针类型
    private String model;
    //设备型号
    private String device;
    //测试状态
    private String teststatus;
    //版本号
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
    //网络设备
    private String networkdevice;
    //健康度
    private Integer dayreport;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：测试机名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：测试机名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取：IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置：vpnip
     */
    public void setVpnip(String vpnip) {
        this.vpnip = vpnip;
    }

    /**
     * 获取：vpnip
     */
    public String getVpnip() {
        return vpnip;
    }

    /**
     * 设置：dnsip
     */
    public void setDnsip(String dnsip) {
        this.dnsip = dnsip;
    }

    /**
     * 获取：dnsip
     */
    public String getDnsip() {
        return dnsip;
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
     * 设置：地市自动
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：地市自动
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
     * 设置：软件标识
     */
    public void setUseruid(String useruid) {
        this.useruid = useruid;
    }

    /**
     * 获取：软件标识
     */
    public String getUseruid() {
        return useruid;
    }

    /**
     * 设置：硬件编码
     */
    public void setSysuuid(String sysuuid) {
        this.sysuuid = sysuuid;
    }

    /**
     * 获取：硬件编码
     */
    public String getSysuuid() {
        return sysuuid;
    }

    /**
     * 设置：归属地
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取：归属地
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置：运营商自动
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * 获取：运营商自动
     */
    public String getIsp() {
        return isp;
    }

    /**
     * 设置：网络类型
     */
    public void setNetworktype(String networktype) {
        this.networktype = networktype;
    }

    /**
     * 获取：网络类型
     */
    public String getNetworktype() {
        return networktype;
    }

    /**
     * 设置：网络层次
     */
    public void setAccesslayer(String accesslayer) {
        this.accesslayer = accesslayer;
    }

    /**
     * 获取：网络层次
     */
    public String getAccesslayer() {
        return accesslayer;
    }

    /**
     * 设置：运营商
     */
    public void setIspMan(String ispMan) {
        this.ispMan = ispMan;
    }

    /**
     * 获取：运营商
     */
    public String getIspMan() {
        return ispMan;
    }

    /**
     * 设置：接入类型
     */
    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype;
    }

    /**
     * 获取：接入类型
     */
    public String getAccesstype() {
        return accesstype;
    }

    /**
     * 设置：上联BRAS
     */
    public void setUplink(String uplink) {
        this.uplink = uplink;
    }

    /**
     * 获取：上联BRAS
     */
    public String getUplink() {
        return uplink;
    }

    /**
     * 设置：测试任务ID
     */
    public void setTestgroup(Integer testgroup) {
        this.testgroup = testgroup;
    }

    /**
     * 获取：测试任务ID
     */
    public Integer getTestgroup() {
        return testgroup;
    }

    /**
     * 设置：测试任务组
     */
    public void setTestgroupName(String testgroupName) {
        this.testgroupName = testgroupName;
    }

    /**
     * 获取：测试任务组
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
     * 设置：在线时间
     */
    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    /**
     * 获取：在线时间
     */
    public Date getOnlineTime() {
        return onlineTime;
    }

    /**
     * 设置：
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取：
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置：探针类型
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取：探针类型
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
     * 设置：测试状态
     */
    public void setTeststatus(String teststatus) {
        this.teststatus = teststatus;
    }

    /**
     * 获取：测试状态
     */
    public String getTeststatus() {
        return teststatus;
    }

    /**
     * 设置：版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取：版本号
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
     * 设置：网络设备
     */
    public void setNetworkdevice(String networkdevice) {
        this.networkdevice = networkdevice;
    }

    /**
     * 获取：网络设备
     */
    public String getNetworkdevice() {
        return networkdevice;
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
