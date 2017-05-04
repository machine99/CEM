package com.baolian.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.entity.map.BrasGametestResult;
import com.baolian.entity.map.CountyGametestResult;
import com.baolian.entity.map.WebGameCountResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.ResultGametestEntity;
import com.baolian.service.ResultGametestService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("resultgametest")
public class ResultGametestController {
    @Autowired
    private ResultGametestService resultGametestService;

    @RequestMapping("/resultgametest.html")
    public String list() {
        return "resultgametest/resultgametest.html";
    }

    /**
     * 列表
     */

    @ResponseBody
    @RequestMapping("/countygamelist")
    @RequiresPermissions("resultgametest:countygamelist")
    public R list(String starttime, String endtime, String area) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("county", area);

        System.out.println("starttime:" + starttime);
        System.out.println("endtime:" + endtime);
        System.out.println("county:" + area);


        //查询列表数据
        List<CountyGametestResult> resultCountyGametestList = resultGametestService.queryCountyGameList(map);

        for (CountyGametestResult result : resultCountyGametestList) {
            System.out.println(result);
        }

        if (resultCountyGametestList.size() == 1 && "".equals(area)) {
            if (resultCountyGametestList.get(0).getCounty().equals("新城区")) {
                resultCountyGametestList.add(new CountyGametestResult("碑林区", 0, 0.0, 0.0, 0.0, 0.0));
            } else if (resultCountyGametestList.get(0).getCounty().equals("碑林区")) {
                resultCountyGametestList.add(0, new CountyGametestResult("新城区", 0, 0.0, 0.0, 0.0, 0.0));
            }
        }
        return R.ok().put("resultCountyGametestList", resultCountyGametestList);
    }

    @ResponseBody
    @RequestMapping("/brasgamelist")
    @RequiresPermissions("resultgametest:brasgamelist")
    public R brasList(String starttime, String endtime) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        //查询列表数据
        List<BrasGametestResult> resultBRASGametestList = resultGametestService.queryBRASGameList(map);

        return R.ok().put("resultBRASGametestList", resultBRASGametestList);
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("resultgametest:list")
    public R list(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);

        //查询列表数据
        List<ResultGametestEntity> resultGametestList = resultGametestService.queryList(map);
        int total = resultGametestService.queryTotal(map);

        PageUtils pageUtil = new PageUtils(resultGametestList, total, limit, page);

        return R.ok().put("page", pageUtil);
    }

    /**
     *
     * @param starttime
     * @param endtime
     * @return
     */
    @ResponseBody
    @RequestMapping("/weblist")
    @RequiresPermissions("resultgametest:weblist")
    public R list(String starttime, String endtime){
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        System.out.println("starttime:"+starttime);
        System.out.println("endtime:"+endtime);

        //查询列表数据
        List<WebGameCountResult> resultGamewebtestList = resultGametestService.queryWebList(map);


        return R.ok().put("resultGamewebtestList", resultGamewebtestList);
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("resultgametest:info")
    public R info(@PathVariable("id") Integer id) {
        ResultGametestEntity resultGametest = resultGametestService.queryObject(id);

        return R.ok().put("resultGametest", resultGametest);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("resultgametest:save")
    public R save(@RequestBody ResultGametestEntity resultGametest) {
        resultGametestService.save(resultGametest);

        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("resultgametest:update")
    public R update(@RequestBody ResultGametestEntity resultGametest) {
        resultGametestService.update(resultGametest);

        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("resultgametest:delete")
    public R delete(@RequestBody Integer[] ids) {
        resultGametestService.deleteBatch(ids);

        return R.ok();
    }

}
