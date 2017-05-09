package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		int total = 0;

		System.out.println(page);
		System.out.println(limit);
		if(page==null) {              /*没有传入page,则取全部值*/
			map.put("offset", null);
			map.put("limit", null);
			page = 0;
			limit = 0;
		}else {
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			total = testtargetService.queryTotal(map);
		}
		
		//查询列表数据
		List<TesttargetEntity> testtargetList = testtargetService.queryList(map);

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
