package com.xzp.dynamic.multiple.data.source.config;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 14:26
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class YmlMultipleDataSourceProperties {

    private String defaultDbKey;
    private List<Map<String, DataSourceProperties>> dataSources;

    public Map<String, DataSource> getDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(dataSources)) {
            for (Map<String, DataSourceProperties> map : dataSources) {
                for (Map.Entry<String, DataSourceProperties> entry : map.entrySet()) {
                    dataSourceMap.put(entry.getKey(), DynamicMultipleDataSourceUtil.buildDataSource(entry.getValue()));
                }
            }
        }
        return dataSourceMap;
    }

}
