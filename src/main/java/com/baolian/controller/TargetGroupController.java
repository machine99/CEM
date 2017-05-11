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

import com.baolian.entity.TargetGroupEntity;
import com.baolian.service.TargetGroupService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * 
 *
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("targetgroup")
public class TargetGroupController {
	@Autowired
	private TargetGroupService targetGroupService;
	
	@RequestMapping("/targetgroup.html")
	public String list(){
		return "targetgroup/targetgroup.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("targetgroup:list")
	public R list(Integer page, Integer limit, String group_id){
		Map<String, Object> map = new HashMap<>();
		map.put("group_id", group_id);
		int total = 0;
		System.out.println(group_id);
		if(page==null) {              /*没有传入page,则取全部值*/
			map.put("offset", null);
			map.put("limit", null);
			page = 0;
			limit = 0;
		}else {
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			total = targetGroupService.queryTotal(map);
		}
		
		//查询列表数据
		List<TargetGroupEntity> targetGroupList = targetGroupService.queryList(map);

		
		PageUtils pageUtil = new PageUtils(targetGroupList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("targetgroup:info")
	public R info(@PathVariable("id") Integer id){
		TargetGroupEntity targetGroup = targetGroupService.queryObject(id);
		
		return R.ok().put("targetGroup", targetGroup);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("targetgroup:save")
	public R save(@RequestBody TargetGroupEntity targetGroup){
		targetGroupService.save(targetGroup);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("targetgroup:update")
	public R update(@RequestBody TargetGroupEntity targetGroup){
		targetGroupService.update(targetGroup);
		
		return R.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updatebatch")
	@RequiresPermissions("targetgroup:updatebatch")
	public R updatebatch(@RequestBody TargetGroupEntity[] targetGroups){
//		targetGroupService.update(targetGroup);
        for(TargetGroupEntity targetGroup:targetGroups){
			System.out.println("id:"+targetGroup.getId()+";targetid:"+targetGroup.getTargetId()+";groupid:"+targetGroup.getGroupId());
		}
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("targetgroup:delete")
	public R delete(@RequestBody Integer[] ids){
		targetGroupService.deleteBatch(ids);
		for(int i=0;i<ids.length;i++) {
			System.out.println(ids[i]);
		}
		return R.ok();
	}
	
}
