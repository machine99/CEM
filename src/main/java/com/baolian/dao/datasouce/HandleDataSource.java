package com.baolian.dao.datasouce;

/**
 * 处理多数据源的Handle类
 * Created by tomxie on 2017/4/23 11:51.
 */
public class HandleDataSource {
    // 数据源名称线程池
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源
     *
     * @param datasource 数据源名称
     */
    public static void setDataSource(String datasource) {
        holder.set(datasource);
    }

    /**
     * 获取数据源
     *
     * @return 数据源名称
     */
    public static String getDataSource() {
        return holder.get();
    }

    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        holder.remove();
    }
}
