package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.entity.map.BrasPingtestResult;
import com.baolian.entity.map.BrasYoukutestResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.ResultYoukutestEntity;
import com.baolian.service.ResultYoukutestService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * 
 *
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resultyoukutest")
public class ResultYoukutestController {
	@Autowired
	private ResultYoukutestService resultYoukutestService;
	
	@RequestMapping("/resultyoukutest.html")
	public String list(){
		return "resultyoukutest/resultyoukutest.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("resultyoukutest:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<ResultYoukutestEntity> resultYoukutestList = resultYoukutestService.queryList(map);
		int total = resultYoukutestService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(resultYoukutestList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * BRASPing感知列表
	 */
	@ResponseBody
	@RequestMapping("/brasyoukulist")
	@RequiresPermissions("resultyoukutest:brasyoukulist")
	public R brasList(String starttime, String endtime) {
		Map<String, Object> map = new HashMap<>();
		map.put("starttime", starttime);
		map.put("endtime", endtime);

		//查询列表数据
		List<BrasYoukutestResult> resultBRASYoukutestList = resultYoukutestService.queryBRASYoukuList(map);
		return R.ok().put("resultBRASYoukutestList", resultBRASYoukutestList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("resultyoukutest:info")
	public R info(@PathVariable("id") Integer id){
		ResultYoukutestEntity resultYoukutest = resultYoukutestService.queryObject(id);
		
		return R.ok().put("resultYoukutest", resultYoukutest);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("resultyoukutest:save")
	public R save(@RequestBody ResultYoukutestEntity resultYoukutest){
		resultYoukutestService.save(resultYoukutest);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("resultyoukutest:update")
	public R update(@RequestBody ResultYoukutestEntity resultYoukutest){
		resultYoukutestService.update(resultYoukutest);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("resultyoukutest:delete")
	public R delete(@RequestBody Integer[] ids){
		resultYoukutestService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
