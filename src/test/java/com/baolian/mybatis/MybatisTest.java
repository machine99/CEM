package com.baolian.mybatis;

import com.baolian.entity.map.*;
import com.baolian.entity.map.comp.ResultDateComparator;
import com.baolian.service.*;
import com.baolian.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Mybatis测试类
 * Created by tomxie on 2017/4/20 13:47.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-baolian.xml"})
public class MybatisTest {
    @Autowired
    private ResultPingtestService resultPingtestService;
    @Autowired
    private ResultHttptestService resultHttptestService;
    @Autowired
    private ResultGametestService resultGametestService;
    @Autowired
    private ResultYoukutestService resultYoukutestService;
    @Autowired
    private ResultSpeedtestService resultSpeedtestService;
    @Autowired
    private TestagentService testagentService;
    @Autowired
    private TesttargetService testtargetService;

    @Test
    public void RunMybatisTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", "2016-04-01 00:00:00");
        map.put("endtime", "2017-04-30 00:00:00");
        map.put("groupByTime", 2); // 按照月份

        // List<String> list = testagentService.queryBrasNames();
        // for (String s : list) {
        //     System.out.println(s);
        // }

        // //查询列表数据
        // List<BaseResult> brasPingtestResults = resultPingtestService.queryPingMonthList(map);
        // List<BaseResult> brasHttptestResults = resultHttptestService.queryHttpMonthList(map);
        // List<BaseResult> brasSpeedtestResults = resultSpeedtestService.querySpeedMonthList(map);
        // List<BaseResult> brasGametestResults = resultGametestService.queryGameMonthList(map);
        // List<BaseResult> brasYoukutestResults = resultYoukutestService.queryYoukuMonthList(map);
        //
        // Map<String, TotalBaseResult> resultMap = new HashMap<>();
        //
        // for (BaseResult result : brasPingtestResults) {
        //     String date = result.getDate();
        //     if (!resultMap.containsKey(date)) {
        //         resultMap.put(date, new TotalBaseResult(date));
        //     }
        //     resultMap.get(date).setPingAvgQoe(result.getQoe());
        // }
        // for (BaseResult result : brasHttptestResults) {
        //     String date = result.getDate();
        //     if (!resultMap.containsKey(date)) {
        //         resultMap.put(date, new TotalBaseResult(date));
        //     }
        //     resultMap.get(date).setHttpAvgQoe(result.getQoe());
        // }
        // for (BaseResult result : brasSpeedtestResults) {
        //     String date = result.getDate();
        //     if (!resultMap.containsKey(date)) {
        //         resultMap.put(date, new TotalBaseResult(date));
        //     }
        //     resultMap.get(date).setSpeedAvgQoe(result.getQoe());
        // }
        // for (BaseResult result : brasGametestResults) {
        //     String date = result.getDate();
        //     if (!resultMap.containsKey(date)) {
        //         resultMap.put(date, new TotalBaseResult(date));
        //     }
        //     resultMap.get(date).setGameAvgQoe(result.getQoe());
        // }
        // for (BaseResult result : brasYoukutestResults) {
        //     String date = result.getDate();
        //     if (!resultMap.containsKey(date)) {
        //         resultMap.put(date, new TotalBaseResult(date));
        //     }
        //     resultMap.get(date).setYoukuAvgQoe(result.getQoe());
        // }
        // List<TotalBaseResult> list = new ArrayList<>(resultMap.values());
        // Collections.sort(list, new ResultDateComparator<TotalBaseResult>(DateUtils.MONTH_PATTERN));
        // for (TotalBaseResult result : list) {
        //     System.out.println(result);
        // }
        List<CityPingtestResult> cityPingtestResults = resultPingtestService.queryCityAvgList(map);
        for (CityPingtestResult result : cityPingtestResults) {
            System.out.println(result);
        }
    }
}
