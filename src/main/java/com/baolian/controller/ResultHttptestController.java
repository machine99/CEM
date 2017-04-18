package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.ResultHttptestEntity;
import com.baolian.service.ResultHttptestService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * 
 *
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resulthttptest")
public class ResultHttptestController {
	@Autowired
	private ResultHttptestService resultHttptestService;
	
	@RequestMapping("/resulthttptest.html")
	public String list(){
		return "resulthttptest/resulthttptest.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("resulthttptest:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<ResultHttptestEntity> resultHttptestList = resultHttptestService.queryList(map);
		int total = resultHttptestService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(resultHttptestList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("resulthttptest:info")
	public R info(@PathVariable("id") Integer id){
		ResultHttptestEntity resultHttptest = resultHttptestService.queryObject(id);
		
		return R.ok().put("resultHttptest", resultHttptest);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("resulthttptest:save")
	public R save(@RequestBody ResultHttptestEntity resultHttptest){
		resultHttptestService.save(resultHttptest);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("resulthttptest:update")
	public R update(@RequestBody ResultHttptestEntity resultHttptest){
		resultHttptestService.update(resultHttptest);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("resulthttptest:delete")
	public R delete(@RequestBody Integer[] ids){
		resultHttptestService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
