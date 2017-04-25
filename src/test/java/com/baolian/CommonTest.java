package com.baolian;

import com.baolian.entity.TestagentEntity;
import org.junit.Test;

/**
 * 普通测试类
 * Created by tomxie on 2017/4/25 14:49.
 */
public class CommonTest {
    @Test
    public void RunTest() {
        Class<TestagentEntity> c = TestagentEntity.class;
        System.out.println(c.getSimpleName().toLowerCase().replaceAll("entity", ""));
    }
}
