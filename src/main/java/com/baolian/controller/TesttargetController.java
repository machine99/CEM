package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baolian.entity.TesttargetEntity;
import com.baolian.utils.JSONUtils;
import com.baolian.utils.RRException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.TesttargetEntity;
import com.baolian.service.TesttargetService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("testtarget")
public class TesttargetController {
	@Autowired
	private TesttargetService testtargetService;
	
	@RequestMapping("/testtarget.html")
	public String list(){
		return "testtarget/testtarget.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("testtarget:list")
	public R list(String probedata, Integer page, Integer limit) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		System.out.println(probedata);
		System.out.println(page);
		JSONObject probedata_jsonobject = JSONObject.parseObject(probedata);
		try {
			map.putAll(JSONUtils.jsonToMap(probedata_jsonobject));
			System.out.println(map.toString());
		} catch (RuntimeException e) {
			throw new RRException("内部参数错误，请重试！");
		}
		List<TesttargetEntity> testtargetList = testtargetService.queryList(map);
		int total = testtargetService.queryTotal(map);
		PageUtils pageUtil = new PageUtils(testtargetList, total, limit, page);
		return R.ok().put("page", pageUtil);
	}



	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("testtarget:info")
	public R info(@PathVariable("id") Integer id){
		TesttargetEntity testtarget = testtargetService.queryObject(id);
		
		return R.ok().put("testtarget", testtarget);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("testtarget:save")
	public R save(@RequestBody TesttargetEntity testtarget){
		testtargetService.save(testtarget);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("testtarget:update")
	public R update(@RequestBody TesttargetEntity testtarget){
		testtargetService.update(testtarget);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("testtarget:delete")
	public R delete(@RequestBody Integer[] ids){
		testtargetService.deleteBatch(ids);
		
		return R.ok();
	}
	

}
