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
public class ResultPingtestEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//测试任务分组
	private String guid;
	//成功失败标记
	private Integer state;
	//失败原因
	private String errorcode;
	//测试端口ID
	private Integer destid;
	//测试目标
	private String destname;
	//目标IP
	private String destip;
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
	//平均时延
	private Double rttAvg;
	//最小时延
	private Double rttMin;
	//最大时延
	private Double rttMax;
	//时延方差
	private Double rttStd;
	//抖动
	private Double jitter;
	//丢包
	private Double loss;
	//countSend
	private Integer countSend;
	//countRecv
	private Integer countRecv;
	//rttJcount
	private Integer rttJcount;
	//rttAvg2
	private Double rttAvg2;
	//rttJitter2
	private Double rttJitter2;
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
	 * 设置：测试端口ID
	 */
	public void setDestid(Integer destid) {
		this.destid = destid;
	}
	/**
	 * 获取：测试端口ID
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
	 * 设置：平均时延
	 */
	public void setRttAvg(Double rttAvg) {
		this.rttAvg = rttAvg;
	}
	/**
	 * 获取：平均时延
	 */
	public Double getRttAvg() {
		return rttAvg;
	}
	/**
	 * 设置：最小时延
	 */
	public void setRttMin(Double rttMin) {
		this.rttMin = rttMin;
	}
	/**
	 * 获取：最小时延
	 */
	public Double getRttMin() {
		return rttMin;
	}
	/**
	 * 设置：最大时延
	 */
	public void setRttMax(Double rttMax) {
		this.rttMax = rttMax;
	}
	/**
	 * 获取：最大时延
	 */
	public Double getRttMax() {
		return rttMax;
	}
	/**
	 * 设置：时延方差
	 */
	public void setRttStd(Double rttStd) {
		this.rttStd = rttStd;
	}
	/**
	 * 获取：时延方差
	 */
	public Double getRttStd() {
		return rttStd;
	}
	/**
	 * 设置：抖动
	 */
	public void setJitter(Double jitter) {
		this.jitter = jitter;
	}
	/**
	 * 获取：抖动
	 */
	public Double getJitter() {
		return jitter;
	}
	/**
	 * 设置：丢包
	 */
	public void setLoss(Double loss) {
		this.loss = loss;
	}
	/**
	 * 获取：丢包
	 */
	public Double getLoss() {
		return loss;
	}
	/**
	 * 设置：countSend
	 */
	public void setCountSend(Integer countSend) {
		this.countSend = countSend;
	}
	/**
	 * 获取：countSend
	 */
	public Integer getCountSend() {
		return countSend;
	}
	/**
	 * 设置：countRecv
	 */
	public void setCountRecv(Integer countRecv) {
		this.countRecv = countRecv;
	}
	/**
	 * 获取：countRecv
	 */
	public Integer getCountRecv() {
		return countRecv;
	}
	/**
	 * 设置：rttJcount
	 */
	public void setRttJcount(Integer rttJcount) {
		this.rttJcount = rttJcount;
	}
	/**
	 * 获取：rttJcount
	 */
	public Integer getRttJcount() {
		return rttJcount;
	}
	/**
	 * 设置：rttAvg2
	 */
	public void setRttAvg2(Double rttAvg2) {
		this.rttAvg2 = rttAvg2;
	}
	/**
	 * 获取：rttAvg2
	 */
	public Double getRttAvg2() {
		return rttAvg2;
	}
	/**
	 * 设置：rttJitter2
	 */
	public void setRttJitter2(Double rttJitter2) {
		this.rttJitter2 = rttJitter2;
	}
	/**
	 * 获取：rttJitter2
	 */
	public Double getRttJitter2() {
		return rttJitter2;
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
}
