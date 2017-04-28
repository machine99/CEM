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

import com.baolian.entity.TestgroupEntity;
import com.baolian.service.TestgroupService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * 
 *
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("testgroup")
public class TestgroupController {
	@Autowired
	private TestgroupService testgroupService;
	
	@RequestMapping("/testgroup.html")
	public String list(){
		return "testgroup/testgroup.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("testgroup:list")
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
			total = testgroupService.queryTotal(map);
		}
		
		//查询列表数据
		List<TestgroupEntity> testgroupList = testgroupService.queryList(map);

		
		PageUtils pageUtil = new PageUtils(testgroupList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}

	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("testgroup:info")
	public R info(@PathVariable("id") Integer id){
		System.out.println("取得id值:"+id);
		TestgroupEntity testgroup = testgroupService.queryObject(id);
		
		return R.ok().put("testgroup", testgroup);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("testgroup:save")
	public R save(@RequestBody TestgroupEntity testgroup){
		testgroupService.save(testgroup);
		System.out.println("录入:"+testgroup);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("testgroup:update")
	public R update(@RequestBody TestgroupEntity testgroup){
		testgroupService.update(testgroup);
		System.out.println("更新:"+testgroup);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("testgroup:delete")
	public R delete(@RequestBody Integer[] ids){
		testgroupService.deleteBatch(ids);
		for(Integer id:ids){
			System.out.println("要删除的:"+id);
		}
		return R.ok();
	}
	
}
