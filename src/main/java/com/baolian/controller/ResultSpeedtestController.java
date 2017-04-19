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

import com.baolian.entity.ResultSpeedtestEntity;
import com.baolian.service.ResultSpeedtestService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * 
 *
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resultspeedtest")
public class ResultSpeedtestController {
	@Autowired
	private ResultSpeedtestService resultSpeedtestService;
	
	@RequestMapping("/resultspeedtest.html")
	public String list(){
		return "resultspeedtest/resultspeedtest.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("resultspeedtest:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<ResultSpeedtestEntity> resultSpeedtestList = resultSpeedtestService.queryList(map);
		int total = resultSpeedtestService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(resultSpeedtestList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("resultspeedtest:info")
	public R info(@PathVariable("id") Integer id){
		ResultSpeedtestEntity resultSpeedtest = resultSpeedtestService.queryObject(id);
		
		return R.ok().put("resultSpeedtest", resultSpeedtest);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("resultspeedtest:save")
	public R save(@RequestBody ResultSpeedtestEntity resultSpeedtest){
		resultSpeedtestService.save(resultSpeedtest);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("resultspeedtest:update")
	public R update(@RequestBody ResultSpeedtestEntity resultSpeedtest){
		resultSpeedtestService.update(resultSpeedtest);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("resultspeedtest:delete")
	public R delete(@RequestBody Integer[] ids){
		resultSpeedtestService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
