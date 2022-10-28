package com.xzp.dynamic.multiple.data.source.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 17:00
 */
@Slf4j
public class DynamicMultipleDataSourceUtil {

    private static final Map<Object, Object> TARGET_DATA_SOURCES = new HashMap<>();

    public static void addDataSource(String name, DataSource dataSource) {
        log.info("添加数据源:{}", name);
        DynamicMultipleDataSource dynamicMultipleDataSource = ApplicationContextUtil.getBean(DynamicMultipleDataSource.class);
        TARGET_DATA_SOURCES.put(name, dataSource);
        dynamicMultipleDataSource.setTargetDataSources(TARGET_DATA_SOURCES);
        dynamicMultipleDataSource.afterPropertiesSet();
    }

    public static DataSource buildDataSource(DataSourceProperties prop) {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.type(prop.getType());
        builder.driverClassName(prop.getDriverClassName());
        builder.username(prop.getUsername());
        builder.password(prop.getPassword());
        builder.url(prop.getUrl());
        return builder.build();
    }
}
