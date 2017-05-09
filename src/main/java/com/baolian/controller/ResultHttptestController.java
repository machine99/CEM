package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.entity.map.BrasHttptestResult;
import com.baolian.entity.map.CountyHttptestResult;
import com.baolian.entity.map.TopAliasResult;
import com.baolian.entity.map.WebHttpCountResult;
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
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resulthttptest")
public class ResultHttptestController {
    @Autowired
    private ResultHttptestService resultHttptestService;

    @RequestMapping("/resulthttptest.html")
    public String list() {
        return "resulthttptest/resulthttptest.html";
    }

    /**
     * 列表
     */

    @ResponseBody
    @RequestMapping("/countyhttplist")
    @RequiresPermissions("resulthttptest:countyhttplist")
    public R list(String starttime, String endtime, String area) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("county", area);

        System.out.println("starttime:" + starttime);
        System.out.println("endtime:" + endtime);
        System.out.println("county:" + area);


        //查询列表数据
        List<CountyHttptestResult> resultCountyHttptestList = resultHttptestService.queryCountyHttpList(map);

        for (CountyHttptestResult result : resultCountyHttptestList) {
            System.out.println(result);
        }

        if (resultCountyHttptestList.size() == 1 && "".equals(area)) {
            if (resultCountyHttptestList.get(0).getCounty().equals("新城区")) {
                resultCountyHttptestList.add(new CountyHttptestResult("碑林区", 0, 0.0, 0.0, 0.0, 0.0, 0.0));
            } else if (resultCountyHttptestList.get(0).getCounty().equals("碑林区")) {
                resultCountyHttptestList.add(0, new CountyHttptestResult("新城区", 0, 0.0, 0.0, 0.0, 0.0, 0.0));
            }
        }
        return R.ok().put("resultCountyHttptestList", resultCountyHttptestList);
    }

    @ResponseBody
    @RequestMapping("/brashttplist")
    @RequiresPermissions("resulthttptest:brashttplist")
    public R brasList(String starttime, String endtime) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        //查询列表数据
        List<BrasHttptestResult> resultBRASHttptestList = resultHttptestService.queryBRASHttpList(map);

        return R.ok().put("resultBRASHttptestList", resultBRASHttptestList);
    }

    // 首页获得网站Top排行
    @ResponseBody
    @RequestMapping("/topaliaslist")
    @RequiresPermissions("resulthttptest:topaliaslist")
    public R topAliasList(Integer limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", limit);

        //查询数据
        List<TopAliasResult> resultTopAliasList = resultHttptestService.queryTopAlias(map);

        return R.ok().put("resultTopAliasList", resultTopAliasList);
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("resulthttptest:list")
    public R list(Integer page, Integer limit) {
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
     * @param starttime
     * @param endtime
     * @return
     */
    @ResponseBody
    @RequestMapping("/weblist")
    @RequiresPermissions("resulthttptest:weblist")
    public R list(String starttime, String endtime) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        System.out.println("starttime:" + starttime);
        System.out.println("endtime:" + endtime);

        //查询列表数据
        List<WebHttpCountResult> resultHttpwebtestList = resultHttptestService.queryWebList(map);


        return R.ok().put("resultHttpwebtestList", resultHttpwebtestList);
    }


    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("resulthttptest:info")
    public R info(@PathVariable("id") Integer id) {
        ResultHttptestEntity resultHttptest = resultHttptestService.queryObject(id);

        return R.ok().put("resultHttptest", resultHttptest);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("resulthttptest:save")
    public R save(@RequestBody ResultHttptestEntity resultHttptest) {
        resultHttptestService.save(resultHttptest);

        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("resulthttptest:update")
    public R update(@RequestBody ResultHttptestEntity resultHttptest) {
        resultHttptestService.update(resultHttptest);

        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("resulthttptest:delete")
    public R delete(@RequestBody Integer[] ids) {
        resultHttptestService.deleteBatch(ids);

        return R.ok();
    }

}
