package com.baolian.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public class ResultYoukutestEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//guid
	private String guid;
	//state
	private Integer state;
	//失败原因
	private String errorcode;
	//destid
	private Integer destid;
	//测试目标
	private String destname;
	//测试时间
	private Date testtime;
	//测试花销时长
	private Double elapsetime;
	//测试机
	private String testagent;
	//qoe
	private Double qoe;
	//qoemodel
	private Integer qoemodel;
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
	//tcpcount
	private Integer tcpcount;
	//tcphead
	private Double tcphead;
	//tcpconn
	private Double tcpconn;
	//tcpretrans
	private Integer tcpretrans;
	//l2delay
	private Double l2delay;
	//l2loss
	private Double l2loss;
	//l2trace
	private String l2trace;
	//l2tracedelay
	private String l2tracedelay;
	//lanhoops
	private Integer lanhoops;
	//landelay
	private Integer landelay;
	//sharepc
	private Integer sharepc;
	//wanip
	private String wanip;
	//lanip
	private String lanip;
	//sysbacknetwork
	private Double sysbacknetwork;
	//syscpuusage
	private Double syscpuusage;
	//syscpu
	private Double syscpu;
	//sysmemusage
	private Double sysmemusage;
	//sysmem
	private Double sysmem;
	//sysadapterrate
	private Double sysadapterrate;
	//sysadapter
	private String sysadapter;
	//sysapps
	private Integer sysapps;
	//sysos
	private String sysos;
	//testagentid
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
	 * 设置：guid
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	/**
	 * 获取：guid
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * 设置：state
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：state
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
	 * 设置：测试花销时长
	 */
	public void setElapsetime(Double elapsetime) {
		this.elapsetime = elapsetime;
	}
	/**
	 * 获取：测试花销时长
	 */
	public Double getElapsetime() {
		return elapsetime;
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
	 * 设置：qoemodel
	 */
	public void setQoemodel(Integer qoemodel) {
		this.qoemodel = qoemodel;
	}
	/**
	 * 获取：qoemodel
	 */
	public Integer getQoemodel() {
		return qoemodel;
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
	 * 设置：tcpcount
	 */
	public void setTcpcount(Integer tcpcount) {
		this.tcpcount = tcpcount;
	}
	/**
	 * 获取：tcpcount
	 */
	public Integer getTcpcount() {
		return tcpcount;
	}
	/**
	 * 设置：tcphead
	 */
	public void setTcphead(Double tcphead) {
		this.tcphead = tcphead;
	}
	/**
	 * 获取：tcphead
	 */
	public Double getTcphead() {
		return tcphead;
	}
	/**
	 * 设置：tcpconn
	 */
	public void setTcpconn(Double tcpconn) {
		this.tcpconn = tcpconn;
	}
	/**
	 * 获取：tcpconn
	 */
	public Double getTcpconn() {
		return tcpconn;
	}
	/**
	 * 设置：tcpretrans
	 */
	public void setTcpretrans(Integer tcpretrans) {
		this.tcpretrans = tcpretrans;
	}
	/**
	 * 获取：tcpretrans
	 */
	public Integer getTcpretrans() {
		return tcpretrans;
	}
	/**
	 * 设置：l2delay
	 */
	public void setL2delay(Double l2delay) {
		this.l2delay = l2delay;
	}
	/**
	 * 获取：l2delay
	 */
	public Double getL2delay() {
		return l2delay;
	}
	/**
	 * 设置：l2loss
	 */
	public void setL2loss(Double l2loss) {
		this.l2loss = l2loss;
	}
	/**
	 * 获取：l2loss
	 */
	public Double getL2loss() {
		return l2loss;
	}
	/**
	 * 设置：l2trace
	 */
	public void setL2trace(String l2trace) {
		this.l2trace = l2trace;
	}
	/**
	 * 获取：l2trace
	 */
	public String getL2trace() {
		return l2trace;
	}
	/**
	 * 设置：l2tracedelay
	 */
	public void setL2tracedelay(String l2tracedelay) {
		this.l2tracedelay = l2tracedelay;
	}
	/**
	 * 获取：l2tracedelay
	 */
	public String getL2tracedelay() {
		return l2tracedelay;
	}
	/**
	 * 设置：lanhoops
	 */
	public void setLanhoops(Integer lanhoops) {
		this.lanhoops = lanhoops;
	}
	/**
	 * 获取：lanhoops
	 */
	public Integer getLanhoops() {
		return lanhoops;
	}
	/**
	 * 设置：landelay
	 */
	public void setLandelay(Integer landelay) {
		this.landelay = landelay;
	}
	/**
	 * 获取：landelay
	 */
	public Integer getLandelay() {
		return landelay;
	}
	/**
	 * 设置：sharepc
	 */
	public void setSharepc(Integer sharepc) {
		this.sharepc = sharepc;
	}
	/**
	 * 获取：sharepc
	 */
	public Integer getSharepc() {
		return sharepc;
	}
	/**
	 * 设置：wanip
	 */
	public void setWanip(String wanip) {
		this.wanip = wanip;
	}
	/**
	 * 获取：wanip
	 */
	public String getWanip() {
		return wanip;
	}
	/**
	 * 设置：lanip
	 */
	public void setLanip(String lanip) {
		this.lanip = lanip;
	}
	/**
	 * 获取：lanip
	 */
	public String getLanip() {
		return lanip;
	}
	/**
	 * 设置：sysbacknetwork
	 */
	public void setSysbacknetwork(Double sysbacknetwork) {
		this.sysbacknetwork = sysbacknetwork;
	}
	/**
	 * 获取：sysbacknetwork
	 */
	public Double getSysbacknetwork() {
		return sysbacknetwork;
	}
	/**
	 * 设置：syscpuusage
	 */
	public void setSyscpuusage(Double syscpuusage) {
		this.syscpuusage = syscpuusage;
	}
	/**
	 * 获取：syscpuusage
	 */
	public Double getSyscpuusage() {
		return syscpuusage;
	}
	/**
	 * 设置：syscpu
	 */
	public void setSyscpu(Double syscpu) {
		this.syscpu = syscpu;
	}
	/**
	 * 获取：syscpu
	 */
	public Double getSyscpu() {
		return syscpu;
	}
	/**
	 * 设置：sysmemusage
	 */
	public void setSysmemusage(Double sysmemusage) {
		this.sysmemusage = sysmemusage;
	}
	/**
	 * 获取：sysmemusage
	 */
	public Double getSysmemusage() {
		return sysmemusage;
	}
	/**
	 * 设置：sysmem
	 */
	public void setSysmem(Double sysmem) {
		this.sysmem = sysmem;
	}
	/**
	 * 获取：sysmem
	 */
	public Double getSysmem() {
		return sysmem;
	}
	/**
	 * 设置：sysadapterrate
	 */
	public void setSysadapterrate(Double sysadapterrate) {
		this.sysadapterrate = sysadapterrate;
	}
	/**
	 * 获取：sysadapterrate
	 */
	public Double getSysadapterrate() {
		return sysadapterrate;
	}
	/**
	 * 设置：sysadapter
	 */
	public void setSysadapter(String sysadapter) {
		this.sysadapter = sysadapter;
	}
	/**
	 * 获取：sysadapter
	 */
	public String getSysadapter() {
		return sysadapter;
	}
	/**
	 * 设置：sysapps
	 */
	public void setSysapps(Integer sysapps) {
		this.sysapps = sysapps;
	}
	/**
	 * 获取：sysapps
	 */
	public Integer getSysapps() {
		return sysapps;
	}
	/**
	 * 设置：sysos
	 */
	public void setSysos(String sysos) {
		this.sysos = sysos;
	}
	/**
	 * 获取：sysos
	 */
	public String getSysos() {
		return sysos;
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
