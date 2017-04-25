package com.baolian.dao.datasouce;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by tomxie on 2017/4/23 11:50.
 */
public class DataSourceRouter extends AbstractRoutingDataSource {
    // 获取数据源名称
    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }
}
