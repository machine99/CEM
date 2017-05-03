package com.baolian.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.entity.map.CountyYoukutestResult;
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

	@ResponseBody
	@RequestMapping("/countyyoukulist")
	@RequiresPermissions("resultyoukutest:countyyoukulist")
	public R list(String starttime, String endtime, String area) {
		Map<String, Object> map = new HashMap<>();
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("county", area);

		System.out.println("starttime:" + starttime);
		System.out.println("endtime:" + endtime);
		System.out.println("county:" + area);


		//查询列表数据
		List<CountyYoukutestResult> resultCountyYoukutestList = resultYoukutestService.queryCountyYoukuList(map);

		for (CountyYoukutestResult result : resultCountyYoukutestList) {
			System.out.println(result);
		}

		if (resultCountyYoukutestList.size() == 1 && "".equals(area)) {
			if (resultCountyYoukutestList.get(0).getCounty().equals("新城区")) {
				resultCountyYoukutestList.add(new CountyYoukutestResult("碑林区", 0, 0.0, 0.0, 0.0, 0.0, 0.0));
			} else if (resultCountyYoukutestList.get(0).getCounty().equals("碑林区")) {
				resultCountyYoukutestList.add(0, new CountyYoukutestResult("新城区", 0, 0.0, 0.0, 0.0, 0.0, 0.0));
			}
		}
		return R.ok().put("resultCountyYoukutestList", resultCountyYoukutestList);
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
