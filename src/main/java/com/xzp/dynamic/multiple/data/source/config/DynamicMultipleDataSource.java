package com.xzp.dynamic.multiple.data.source.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 16:14
 */
public class DynamicMultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicMultipleDataSourceContextHolder.getDataSourceName();
    }

}
