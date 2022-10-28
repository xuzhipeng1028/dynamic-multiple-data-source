package com.xzp.dynamic.multiple.data.source.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 16:28
 */
@Configuration
public class DynamicMultipleDataSourceConfiguration {

    @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DynamicMultipleDataSource dynamicMultipleDataSource() {
        DynamicMultipleDataSource dynamicMultipleDataSource = new DynamicMultipleDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        dynamicMultipleDataSource.setTargetDataSources(targetDataSources);
        dynamicMultipleDataSource.setDefaultTargetDataSource(DynamicMultipleDataSourceUtil.buildDataSource(dataSourceProperties));
        return dynamicMultipleDataSource;
    }

}
