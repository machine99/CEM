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
public class TestgroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//组名
	private String name;
	//描述
	private String more;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：组名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：组名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：描述
	 */
	public void setMore(String more) {
		this.more = more;
	}
	/**
	 * 获取：描述
	 */
	public String getMore() {
		return more;
	}
}
