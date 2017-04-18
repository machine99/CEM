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
public class TesttargetEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String alias;
	//
	private String target;
	//
	private String targetip;
	//
	private String param;
	//
	private String location;
	//
	private String idc;
	//
	private String type;
	//
	private Date createtime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置：
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * 获取：
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 设置：
	 */
	public void setTargetip(String targetip) {
		this.targetip = targetip;
	}
	/**
	 * 获取：
	 */
	public String getTargetip() {
		return targetip;
	}
	/**
	 * 设置：
	 */
	public void setParam(String param) {
		this.param = param;
	}
	/**
	 * 获取：
	 */
	public String getParam() {
		return param;
	}
	/**
	 * 设置：
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：
	 */
	public void setIdc(String idc) {
		this.idc = idc;
	}
	/**
	 * 获取：
	 */
	public String getIdc() {
		return idc;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
