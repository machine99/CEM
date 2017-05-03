package com.baolian;

import com.baolian.entity.TestagentEntity;
import com.baolian.entity.map.TotalBRASQoeResult;
import org.junit.Test;

import java.util.*;

/**
 * 普通测试类
 * Created by tomxie on 2017/4/25 14:49.
 */
public class CommonTest {
    @Test
    public void RunTest() {
        Map<String, TotalBRASQoeResult> map = new HashMap<>();
        map.put("bras1", new TotalBRASQoeResult("bras1"));
        map.put("bras2", new TotalBRASQoeResult("bras2"));
        map.put("bras3", new TotalBRASQoeResult("bras3"));
        map.put("bras4", new TotalBRASQoeResult("bras4"));

        map.get("bras1").setPingAvgQoe(33.3);
        map.get("bras1").setHttpAvgQoe(67.3);
        map.get("bras1").setSpeedAvgQoe(90.5);
        map.get("bras2").setPingAvgQoe(66.6);
        map.get("bras3").setPingAvgQoe(73.9);

        Set<Map.Entry<String, TotalBRASQoeResult>> entries = map.entrySet();
        for (Map.Entry<String, TotalBRASQoeResult> entry : entries) {
            System.out.println(entry.getValue());
        }

    }
}
