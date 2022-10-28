package com.xzp.dynamic.multiple.data.source.config;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 15:02
 */
@Component
public class DataSourceApplicationRunner implements ApplicationRunner {

    @Resource
    private Map<String, MultipleDataSourceProvider> multipleDataSourceProviderMap;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (ObjectUtils.isNotEmpty(multipleDataSourceProviderMap)) {
            Map<String, DataSource> dataSourceMap;
            for (MultipleDataSourceProvider provider : multipleDataSourceProviderMap.values()) {
                dataSourceMap = provider.provide();
                if (ObjectUtils.isNotEmpty(dataSourceMap)) {
                    for (Map.Entry<String, DataSource> entry : dataSourceMap.entrySet()) {
                        DynamicMultipleDataSourceUtil.addDataSource(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
