package com.baolian.controller;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.baolian.entity.map.*;
import com.baolian.entity.map.comp.ResultDateComparator;
import com.baolian.service.*;
import com.baolian.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.TestagentEntity;


/**
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("testagent")
public class TestagentController {
    @Autowired
    private TestagentService testagentService;
    @Autowired
    private ResultPingtestService resultPingtestService;
    @Autowired
    private ResultHttptestService resultHttptestService;
    @Autowired
    private ResultSpeedtestService resultSpeedtestService;
    @Autowired
    private ResultGametestService resultGametestService;
    @Autowired
    private ResultYoukutestService resultYoukutestService;

    @RequestMapping("/testagent.html")
    public String list() {
        return "testagent/testagent.html";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("testagent:list")
    public R list(String probedata, Integer page, Integer limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);
        JSONObject probedata_jsonobject = JSONObject.parseObject(probedata);
        try {
            map.putAll(JSONUtils.jsonToMap(probedata_jsonobject));
        } catch (RuntimeException e) {
            throw new RRException("内部参数错误，请重试！");
        }
        List<TestagentEntity> testagentList = testagentService.queryList(map);
        int total = testagentService.queryTotal(map);
        PageUtils pageUtil = new PageUtils(testagentList, total, limit, page);
        return R.ok().put("page", pageUtil);
    }

    /**
     * 获得全部的BRAS名称
     */
    @ResponseBody
    @RequestMapping("/brasnamelist")
    @RequiresPermissions("testagent:brasnamelist")
    public R brasNameList() {
        List<String> brasNames = testagentService.queryBrasNames();
        return R.ok().put("brasNames", brasNames);
    }

    @ResponseBody
    @RequestMapping("/brasavgqoelist")
    @RequiresPermissions("testagent:brasavgqoelist")
    public R brasAvgQoeList(String starttime, String endtime) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);

        // 查询列表数据
        List<BrasPingtestResult> brasPingtestResults = resultPingtestService.queryBRASPingList(map);
        List<BrasHttptestResult> brasHttptestResults = resultHttptestService.queryBRASHttpList(map);
        List<BrasSpeedtestResult> brasSpeedtestResults = resultSpeedtestService.queryBRASSpeedList(map);
        List<BrasGametestResult> brasGametestResults = resultGametestService.queryBRASGameList(map);
        List<BrasYoukutestResult> brasYoukutestResults = resultYoukutestService.queryBRASYoukuList(map);

        Map<String, TotalBRASQoeResult> resultMap = new HashMap<>();
        // 合并
        for (BrasPingtestResult result : brasPingtestResults) {
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(brasName)) {
                resultMap.put(brasName, new TotalBRASQoeResult(brasName));
            }
            resultMap.get(brasName).setPingAvgQoe(result.getQoe());
        }
        for (BrasHttptestResult result : brasHttptestResults) {
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(brasName)) {
                resultMap.put(brasName, new TotalBRASQoeResult(brasName));
            }
            resultMap.get(brasName).setHttpAvgQoe(result.getQoe());
        }
        for (BrasSpeedtestResult result : brasSpeedtestResults) {
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(brasName)) {
                resultMap.put(brasName, new TotalBRASQoeResult(brasName));
            }
            resultMap.get(brasName).setSpeedAvgQoe(result.getQoe());
        }
        for (BrasGametestResult result : brasGametestResults) {
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(brasName)) {
                resultMap.put(brasName, new TotalBRASQoeResult(brasName));
            }
            resultMap.get(brasName).setGameAvgQoe(result.getQoe());
        }
        for (BrasYoukutestResult result : brasYoukutestResults) {
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(brasName)) {
                resultMap.put(brasName, new TotalBRASQoeResult(brasName));
            }
            resultMap.get(brasName).setYoukuAvgQoe(result.getQoe());
        }

        List<TotalBRASQoeResult> resultBRASAvgQoeList = new ArrayList<>(resultMap.values());
        return R.ok().put("resultBRASAvgQoeList", resultBRASAvgQoeList);
    }

    /**
     * 获取bras每日平均qoe
     */
    @ResponseBody
    @RequestMapping("/brasdailyqoelist")
    @RequiresPermissions("testagent:brasdailyqoelist")
    public R brasDailyQoeList(String starttime, String endtime, String brasname) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("brasName", brasname);
        map.put("groupByDate", true);

        // System.out.println("starttime" + starttime);
        // System.out.println("endtime" + endtime);
        // System.out.println("brasName" + brasname);

        // 查询列表数据
        List<BrasPingtestResult> brasPingtestResults = resultPingtestService.queryBRASPingList(map);
        List<BrasHttptestResult> brasHttptestResults = resultHttptestService.queryBRASHttpList(map);
        List<BrasSpeedtestResult> brasSpeedtestResults = resultSpeedtestService.queryBRASSpeedList(map);
        List<BrasGametestResult> brasGametestResults = resultGametestService.queryBRASGameList(map);
        List<BrasYoukutestResult> brasYoukutestResults = resultYoukutestService.queryBRASYoukuList(map);

        Map<String, TotalBRASQoeResult> resultMap = new HashMap<>();
        // 合并
        for (BrasPingtestResult result : brasPingtestResults) {
            String date = result.getDate();
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBRASQoeResult(brasName, date));
            }
            resultMap.get(date).setPingAvgQoe(result.getQoe());
        }
        for (BrasHttptestResult result : brasHttptestResults) {
            String date = result.getDate();
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBRASQoeResult(brasName, date));
            }
            resultMap.get(date).setHttpAvgQoe(result.getQoe());
        }
        for (BrasSpeedtestResult result : brasSpeedtestResults) {
            String date = result.getDate();
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBRASQoeResult(brasName, date));
            }
            resultMap.get(date).setSpeedAvgQoe(result.getQoe());
        }
        for (BrasGametestResult result : brasGametestResults) {
            String date = result.getDate();
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBRASQoeResult(brasName, date));
            }
            resultMap.get(date).setGameAvgQoe(result.getQoe());
        }
        for (BrasYoukutestResult result : brasYoukutestResults) {
            String date = result.getDate();
            String brasName = result.getBrasName();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBRASQoeResult(brasName, date));
            }
            resultMap.get(date).setYoukuAvgQoe(result.getQoe());
        }

        List<TotalBRASQoeResult> resultBRASDailyQoeList = new ArrayList<>(resultMap.values());
        Collections.sort(resultBRASDailyQoeList, new ResultDateComparator<TotalBRASQoeResult>(DateUtils.DATE_PATTERN));
        for (TotalBRASQoeResult result : resultBRASDailyQoeList) {
            System.out.println(result);
        }
        return R.ok().put("resultBRASDailyQoeList", resultBRASDailyQoeList);
    }

    /**
     * 获取county平均qoe
     */
    @ResponseBody
    @RequestMapping("/countyavgqoelist")
    @RequiresPermissions("testagent:countyavgqoelist")
    public R countyAvgQoeList(String starttime, String endtime, String county) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("county", county);

        // 查询列表数据
        List<CountyPingtestResult> countyPingtestResults = resultPingtestService.queryCountyPingList(map);
        List<CountyHttptestResult> countyHttptestResults = resultHttptestService.queryCountyHttpList(map);
        List<CountySpeedtestResult> countySpeedtestResults = resultSpeedtestService.queryCountySpeedList(map);
        List<CountyGametestResult> countyGametestResults = resultGametestService.queryCountyGameList(map);
        List<CountyYoukutestResult> countyYoukutestResults = resultYoukutestService.queryCountyYoukuList(map);

        Map<String, TotalCountyQoeResult> resultMap = new HashMap<>();
        // 合并
        for (CountyPingtestResult result : countyPingtestResults) {
            String County = result.getCounty();
            if (!resultMap.containsKey(County)) {
                resultMap.put(County, new TotalCountyQoeResult(County));
            }
            resultMap.get(County).setPingAvgQoe(result.getQoe());
        }
        for (CountyHttptestResult result : countyHttptestResults) {
            String County = result.getCounty();
            if (!resultMap.containsKey(County)) {
                resultMap.put(County, new TotalCountyQoeResult(County));
            }
            resultMap.get(County).setHttpAvgQoe(result.getQoe());
        }
        for (CountySpeedtestResult result : countySpeedtestResults) {
            String County = result.getCounty();
            if (!resultMap.containsKey(County)) {
                resultMap.put(County, new TotalCountyQoeResult(County));
            }
            resultMap.get(County).setSpeedAvgQoe(result.getQoe());
        }
        for (CountyGametestResult result : countyGametestResults) {
            String County = result.getCounty();
            if (!resultMap.containsKey(County)) {
                resultMap.put(County, new TotalCountyQoeResult(County));
            }
            resultMap.get(County).setGameAvgQoe(result.getQoe());
        }
        for (CountyYoukutestResult result : countyYoukutestResults) {
            String County = result.getCounty();
            if (!resultMap.containsKey(County)) {
                resultMap.put(County, new TotalCountyQoeResult(County));
            }
            resultMap.get(County).setYoukuAvgQoe(result.getQoe());
        }

        List<TotalCountyQoeResult> resultCountyAvgQoeList = new ArrayList<>(resultMap.values());
        return R.ok().put("resultCountyAvgQoeList", resultCountyAvgQoeList);
    }

    /**
     * 获取区域每日平均qoe
     */
    @ResponseBody
    @RequestMapping("/countydailyqoelist")
    @RequiresPermissions("testagent:countydailyqoelist")
    public R countyDailyQoeList(String starttime, String endtime, String county) {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", starttime);
        map.put("endtime", endtime);
        map.put("county", county);
        map.put("groupByDate", true);

        // System.out.println("starttime" + starttime);
        // System.out.println("endtime" + endtime);
        // System.out.println("brasName" + brasname);

        // 查询列表数据
        List<CountyPingtestResult> countyPingtestResults = resultPingtestService.queryCountyPingList(map);
        List<CountyHttptestResult> countyHttptestResults = resultHttptestService.queryCountyHttpList(map);
        List<CountySpeedtestResult> countySpeedtestResults = resultSpeedtestService.queryCountySpeedList(map);
        List<CountyGametestResult> countyGametestResults = resultGametestService.queryCountyGameList(map);
        List<CountyYoukutestResult> countyYoukutestResults = resultYoukutestService.queryCountyYoukuList(map);

        Map<String, TotalCountyQoeResult> resultMap = new HashMap<>();
        // 合并
        for (CountyPingtestResult result : countyPingtestResults) {
            String date = result.getDate();
            String resultCounty = result.getCounty();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalCountyQoeResult(resultCounty, date));
            }
            resultMap.get(date).setPingAvgQoe(result.getQoe());
        }
        for (CountyHttptestResult result : countyHttptestResults) {
            String date = result.getDate();
            String resultCounty = result.getCounty();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalCountyQoeResult(resultCounty, date));
            }
            resultMap.get(date).setHttpAvgQoe(result.getQoe());
        }
        for (CountySpeedtestResult result : countySpeedtestResults) {
            String date = result.getDate();
            String resultCounty = result.getCounty();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalCountyQoeResult(resultCounty, date));
            }
            resultMap.get(date).setSpeedAvgQoe(result.getQoe());
        }
        for (CountyGametestResult result : countyGametestResults) {
            String date = result.getDate();
            String resultCounty = result.getCounty();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalCountyQoeResult(resultCounty, date));
            }
            resultMap.get(date).setGameAvgQoe(result.getQoe());
        }
        for (CountyYoukutestResult result : countyYoukutestResults) {
            String date = result.getDate();
            String resultCounty = result.getCounty();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalCountyQoeResult(resultCounty, date));
            }
            resultMap.get(date).setYoukuAvgQoe(result.getQoe());
        }

        List<TotalCountyQoeResult> resultCountyDailyQoeList = new ArrayList<>(resultMap.values());
        Collections.sort(resultCountyDailyQoeList, new ResultDateComparator<TotalCountyQoeResult>(DateUtils.DATE_PATTERN));
        for (TotalCountyQoeResult result : resultCountyDailyQoeList) {
            System.out.println(result);
        }
        return R.ok().put("resultCountyDailyQoeList", resultCountyDailyQoeList);
    }

    /**
     * 获取月平均qoe
     */
    @ResponseBody
    @RequestMapping("/monthqoelist")
    // @RequiresPermissions("testagent:monthqoelist")
    public R monthQoeList() {
        Map<String, Object> map = new HashMap<>();

        //查询列表数据
        List<BaseResult> pingMonthList = resultPingtestService.queryPingMonthList(map);
        List<BaseResult> httpMonthList = resultHttptestService.queryHttpMonthList(map);
        List<BaseResult> speedMonthList = resultSpeedtestService.querySpeedMonthList(map);
        List<BaseResult> gameMonthList = resultGametestService.queryGameMonthList(map);
        List<BaseResult> youkuMonthList = resultYoukutestService.queryYoukuMonthList(map);

        Map<String, TotalBaseResult> resultMap = new HashMap<>();

        for (BaseResult result : pingMonthList) {
            String date = result.getDate();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBaseResult(date));
            }
            resultMap.get(date).setPingAvgQoe(result.getQoe());
        }
        for (BaseResult result : httpMonthList) {
            String date = result.getDate();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBaseResult(date));
            }
            resultMap.get(date).setHttpAvgQoe(result.getQoe());
        }
        for (BaseResult result : speedMonthList) {
            String date = result.getDate();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBaseResult(date));
            }
            resultMap.get(date).setSpeedAvgQoe(result.getQoe());
        }
        for (BaseResult result : gameMonthList) {
            String date = result.getDate();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBaseResult(date));
            }
            resultMap.get(date).setGameAvgQoe(result.getQoe());
        }
        for (BaseResult result : youkuMonthList) {
            String date = result.getDate();
            if (!resultMap.containsKey(date)) {
                resultMap.put(date, new TotalBaseResult(date));
            }
            resultMap.get(date).setYoukuAvgQoe(result.getQoe());
        }
        List<TotalBaseResult> resultMonthQoeList = new ArrayList<>(resultMap.values());
        Collections.sort(resultMonthQoeList, new ResultDateComparator<TotalBaseResult>(DateUtils.MONTH_PATTERN));
        // for (TotalBaseResult result : resultMonthQoeList) {
        //     System.out.println(result);
        // }
        return R.ok().put("resultMonthQoeList", resultMonthQoeList);
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("testagent:info")
    public R info(@PathVariable("id") Long id) {
        TestagentEntity testagent = testagentService.queryObject(id);

        return R.ok().put("testagent", testagent);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("testagent:save")
    public R save(@RequestBody TestagentEntity testagent) {    /*介绍json数组对象*/
        testagentService.save(testagent);
        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("testagent:update")
    public R update(@RequestBody TestagentEntity testagent) {
        testagentService.update(testagent);
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("testagent:delete")
    public R delete(@RequestBody Long[] ids) {
        testagentService.deleteBatch(ids);
        return R.ok();
    }
}
