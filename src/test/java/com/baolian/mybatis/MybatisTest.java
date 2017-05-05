package com.baolian.mybatis;

import com.baolian.entity.TestagentEntity;
import com.baolian.entity.TesttargetEntity;
import com.baolian.entity.map.*;
import com.baolian.entity.map.comp.ResultComparator;
import com.baolian.service.*;
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
        map.put("groupByDate", true);

        List<BrasHttptestResult> results = resultHttptestService.queryBRASHttpList(map);
        Collections.sort(results, new ResultComparator<BrasHttptestResult>());
        for (BrasHttptestResult result : results) {
            System.out.println(result);
        }

        // List<String> list = testagentService.queryBrasNames();
        // for (String s : list) {
        //     System.out.println(s);
        // }

        // //查询列表数据
        // List<BrasPingtestResult> brasPingtestResults = resultPingtestService.queryBRASPingList(map);
        // List<BrasHttptestResult> brasHttptestResults = resultHttptestService.queryBRASHttpList(map);
        // List<BrasSpeedtestResult> brasSpeedtestResults = resultSpeedtestService.queryBRASSpeedList(map);
        // List<BrasGametestResult> brasGametestResults = resultGametestService.queryBRASGameList(map);
        // List<BrasYoukutestResult> brasYoukutestResults = resultYoukutestService.queryBRASYoukuList(map);
        //
        // Map<String, TotalBRASQoeResult> resultMap = new HashMap<>();
        //
        // for (BrasPingtestResult result : brasPingtestResults) {
        //     String brasName = result.getBrasName();
        //     if (!resultMap.containsKey(brasName)) {
        //         resultMap.put(brasName, new TotalBRASQoeResult(brasName));
        //     }
        //     resultMap.get(brasName).setPingAvgQoe(result.getQoe());
        // }
        // for (BrasHttptestResult result : brasHttptestResults) {
        //     String brasName = result.getBrasName();
        //     if (!resultMap.containsKey(brasName)) {
        //         resultMap.put(brasName, new TotalBRASQoeResult(brasName));
        //     }
        //     resultMap.get(brasName).setHttpAvgQoe(result.getQoe());
        // }
        // for (BrasSpeedtestResult result : brasSpeedtestResults) {
        //     String brasName = result.getBrasName();
        //     if (!resultMap.containsKey(brasName)) {
        //         resultMap.put(brasName, new TotalBRASQoeResult(brasName));
        //     }
        //     resultMap.get(brasName).setSpeedAvgQoe(result.getQoe());
        // }
        // for (BrasGametestResult result : brasGametestResults) {
        //     String brasName = result.getBrasName();
        //     if (!resultMap.containsKey(brasName)) {
        //         resultMap.put(brasName, new TotalBRASQoeResult(brasName));
        //     }
        //     resultMap.get(brasName).setGameAvgQoe(result.getQoe());
        // }
        // for (BrasYoukutestResult result : brasYoukutestResults) {
        //     String brasName = result.getBrasName();
        //     if (!resultMap.containsKey(brasName)) {
        //         resultMap.put(brasName, new TotalBRASQoeResult(brasName));
        //     }
        //     resultMap.get(brasName).setYoukuAvgQoe(result.getQoe());
        // }
        // Set<Map.Entry<String, TotalBRASQoeResult>> entries = resultMap.entrySet();
        // for (Map.Entry<String, TotalBRASQoeResult> entry : entries) {
        //     System.out.println(entry.getValue());
        // }
    }
}
