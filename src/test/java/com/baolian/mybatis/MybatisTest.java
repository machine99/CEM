package com.baolian.mybatis;

import com.baolian.entity.TestagentEntity;
import com.baolian.entity.TesttargetEntity;
import com.baolian.entity.map.BrasGametestResult;
import com.baolian.entity.map.BrasHttptestResult;
import com.baolian.entity.map.BrasPingtestResult;
import com.baolian.entity.map.CountyPingtestResult;
import com.baolian.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TestagentService testagentService;
    @Autowired
    private TesttargetService testtargetService;

    @Test
    public void RunMybatisTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("starttime", "2016-10-21 00:00:00");
        map.put("endtime", "2017-04-25 00:00:00");
        List<BrasGametestResult> results = resultGametestService.queryBRASGameList(map);
        for (BrasGametestResult result : results) {
            System.out.println(result);
        }
        // List<TesttargetEntity> list = testtargetService.queryList(map);
        // System.out.println(testtargetService.queryTotal(map));
        // for (TesttargetEntity entity : list) {
        //     System.out.println(entity.getId());
        // }
    }
}
