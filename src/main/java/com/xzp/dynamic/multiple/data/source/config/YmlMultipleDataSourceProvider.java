package com.xzp.dynamic.multiple.data.source.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 17:18
 */
@Component
public class YmlMultipleDataSourceProvider implements MultipleDataSourceProvider {

    @Resource
    private YmlMultipleDataSourceProperties ymlMultipleDataSourceProperties;

    @Override
    public Map<String, DataSource> provide() {
        return ymlMultipleDataSourceProperties.getDataSourceMap();
    }

}
