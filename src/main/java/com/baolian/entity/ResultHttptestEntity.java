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
	//测试花销时长
	private Double elapsetime;
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
	//TCP连接数量
	private Integer tcpcount;
	//TCP额外开销
	private Double tcphead;
	//TCP建立时延
	private Double tcpconn;
	//TCP重传次数
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
	//testagentid
	private Integer testagentid;
	//destisp
	private String destisp;
	//destaddr
	private String destaddr;

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
	 * 设置：TCP连接数量
	 */
	public void setTcpcount(Integer tcpcount) {
		this.tcpcount = tcpcount;
	}
	/**
	 * 获取：TCP连接数量
	 */
	public Integer getTcpcount() {
		return tcpcount;
	}
	/**
	 * 设置：TCP额外开销
	 */
	public void setTcphead(Double tcphead) {
		this.tcphead = tcphead;
	}
	/**
	 * 获取：TCP额外开销
	 */
	public Double getTcphead() {
		return tcphead;
	}
	/**
	 * 设置：TCP建立时延
	 */
	public void setTcpconn(Double tcpconn) {
		this.tcpconn = tcpconn;
	}
	/**
	 * 获取：TCP建立时延
	 */
	public Double getTcpconn() {
		return tcpconn;
	}
	/**
	 * 设置：TCP重传次数
	 */
	public void setTcpretrans(Integer tcpretrans) {
		this.tcpretrans = tcpretrans;
	}
	/**
	 * 获取：TCP重传次数
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
	 * 设置：destisp
	 */
	public void setDestisp(String destisp) {
		this.destisp = destisp;
	}
	/**
	 * 获取：destisp
	 */
	public String getDestisp() {
		return destisp;
	}
	/**
	 * 设置：destaddr
	 */
	public void setDestaddr(String destaddr) {
		this.destaddr = destaddr;
	}
	/**
	 * 获取：destaddr
	 */
	public String getDestaddr() {
		return destaddr;
	}
}
