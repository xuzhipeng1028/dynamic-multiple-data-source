package com.xzp.dynamic.multiple.data.source.config;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 16:16
 */
public class DynamicMultipleDataSourceContextHolder {

    private static final ThreadLocal<String> CURRENT_DATASOURCE_NAME = new ThreadLocal<>();

    public static void setDataSourceName(String dataSourceName) {
        CURRENT_DATASOURCE_NAME.set(dataSourceName);
    }

    public static String getDataSourceName() {
        return CURRENT_DATASOURCE_NAME.get();
    }

    public static void clearDataSourceName() {
        CURRENT_DATASOURCE_NAME.remove();
    }
}
