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
public class ResultGametestEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//guid
	private String guid;
	//state
	private Integer state;
	//errorcode
	private String errorcode;
	//destid
	private Integer destid;
	//destname
	private String destname;
	//destip
	private String destip;
	//testtime
	private Date testtime;
	//elapsetime
	private Double elapsetime;
	//testagent
	private String testagent;
	//qoe
	private Double qoe;
	//qoemodel
	private Integer qoemodel;
	//bandwidth
	private Double bandwidth;
	//rttAvg
	private Double rttAvg;
	//rttMin
	private Double rttMin;
	//rttMax
	private Double rttMax;
	//rttStd
	private Double rttStd;
	//tcpconnect
	private Double tcpconnect;
	//jitter
	private Double jitter;
	//loss
	private Double loss;
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
	//testagentid
	private Integer testagentid;
	//extLogin
	private Integer extLogin;

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
	 * 设置：errorcode
	 */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	/**
	 * 获取：errorcode
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
	 * 设置：destname
	 */
	public void setDestname(String destname) {
		this.destname = destname;
	}
	/**
	 * 获取：destname
	 */
	public String getDestname() {
		return destname;
	}
	/**
	 * 设置：destip
	 */
	public void setDestip(String destip) {
		this.destip = destip;
	}
	/**
	 * 获取：destip
	 */
	public String getDestip() {
		return destip;
	}
	/**
	 * 设置：testtime
	 */
	public void setTesttime(Date testtime) {
		this.testtime = testtime;
	}
	/**
	 * 获取：testtime
	 */
	public Date getTesttime() {
		return testtime;
	}
	/**
	 * 设置：elapsetime
	 */
	public void setElapsetime(Double elapsetime) {
		this.elapsetime = elapsetime;
	}
	/**
	 * 获取：elapsetime
	 */
	public Double getElapsetime() {
		return elapsetime;
	}
	/**
	 * 设置：testagent
	 */
	public void setTestagent(String testagent) {
		this.testagent = testagent;
	}
	/**
	 * 获取：testagent
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
	 * 设置：bandwidth
	 */
	public void setBandwidth(Double bandwidth) {
		this.bandwidth = bandwidth;
	}
	/**
	 * 获取：bandwidth
	 */
	public Double getBandwidth() {
		return bandwidth;
	}
	/**
	 * 设置：rttAvg
	 */
	public void setRttAvg(Double rttAvg) {
		this.rttAvg = rttAvg;
	}
	/**
	 * 获取：rttAvg
	 */
	public Double getRttAvg() {
		return rttAvg;
	}
	/**
	 * 设置：rttMin
	 */
	public void setRttMin(Double rttMin) {
		this.rttMin = rttMin;
	}
	/**
	 * 获取：rttMin
	 */
	public Double getRttMin() {
		return rttMin;
	}
	/**
	 * 设置：rttMax
	 */
	public void setRttMax(Double rttMax) {
		this.rttMax = rttMax;
	}
	/**
	 * 获取：rttMax
	 */
	public Double getRttMax() {
		return rttMax;
	}
	/**
	 * 设置：rttStd
	 */
	public void setRttStd(Double rttStd) {
		this.rttStd = rttStd;
	}
	/**
	 * 获取：rttStd
	 */
	public Double getRttStd() {
		return rttStd;
	}
	/**
	 * 设置：tcpconnect
	 */
	public void setTcpconnect(Double tcpconnect) {
		this.tcpconnect = tcpconnect;
	}
	/**
	 * 获取：tcpconnect
	 */
	public Double getTcpconnect() {
		return tcpconnect;
	}
	/**
	 * 设置：jitter
	 */
	public void setJitter(Double jitter) {
		this.jitter = jitter;
	}
	/**
	 * 获取：jitter
	 */
	public Double getJitter() {
		return jitter;
	}
	/**
	 * 设置：loss
	 */
	public void setLoss(Double loss) {
		this.loss = loss;
	}
	/**
	 * 获取：loss
	 */
	public Double getLoss() {
		return loss;
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
	/**
	 * 设置：extLogin
	 */
	public void setExtLogin(Integer extLogin) {
		this.extLogin = extLogin;
	}
	/**
	 * 获取：extLogin
	 */
	public Integer getExtLogin() {
		return extLogin;
	}
}
