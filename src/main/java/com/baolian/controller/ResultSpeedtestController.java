package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.entity.map.BrasSpeedtestResult;
import com.baolian.entity.map.CountySpeedtestResult;
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
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resultspeedtest")
public class ResultSpeedtestController {
    @Autowired
    private ResultSpeedtestService resultSpeedtestService;

    @RequestMapping("/resultspeedtest.html")
    public String list() {
        return "resultspeedtest/resultspeedtest.html";
    }

    @ResponseBody
    @RequestMapping("/countyspeedlist")
    @RequiresPermissions("resultspeedtest:countyspeedlist")
    public R list(String starttime, String endtime, String area) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("county", area);

        System.out.println("starttime:" + starttime);
        System.out.println("endtime:" + endtime);
        System.out.println("county:" + area);


        //查询列表数据
        List<CountySpeedtestResult> resultCountySpeedtestList = resultSpeedtestService.queryCountySpeedList(map);

        for (CountySpeedtestResult result : resultCountySpeedtestList) {
            System.out.println(result);
        }

        if (resultCountySpeedtestList.size() == 1 && "".equals(area)) {
            if (resultCountySpeedtestList.get(0).getCounty().equals("新城区")) {
                resultCountySpeedtestList.add(new CountySpeedtestResult("碑林区", 0, 0.0, 0.0));
            } else if (resultCountySpeedtestList.get(0).getCounty().equals("碑林区")) {
                resultCountySpeedtestList.add(0, new CountySpeedtestResult("新城区", 0, 0.0, 0.0));
            }
        }
        return R.ok().put("resultCountySpeedtestList", resultCountySpeedtestList);
    }

    @ResponseBody
    @RequestMapping("/brasspeedlist")
    @RequiresPermissions("resultspeedtest:brasspeedlist")
    public R brasList(String starttime, String endtime) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        //查询列表数据
        List<BrasSpeedtestResult> resultBRASSpeedtestList = resultSpeedtestService.queryBRASSpeedList(map);
        return R.ok().put("resultBRASSpeedtestList", resultBRASSpeedtestList);
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("resultspeedtest:list")
    public R list(Integer page, Integer limit) {
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
    public R info(@PathVariable("id") Integer id) {
        ResultSpeedtestEntity resultSpeedtest = resultSpeedtestService.queryObject(id);

        return R.ok().put("resultSpeedtest", resultSpeedtest);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("resultspeedtest:save")
    public R save(@RequestBody ResultSpeedtestEntity resultSpeedtest) {
        resultSpeedtestService.save(resultSpeedtest);

        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("resultspeedtest:update")
    public R update(@RequestBody ResultSpeedtestEntity resultSpeedtest) {
        resultSpeedtestService.update(resultSpeedtest);

        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("resultspeedtest:delete")
    public R delete(@RequestBody Integer[] ids) {
        resultSpeedtestService.deleteBatch(ids);

        return R.ok();
    }

}
