package com.xzp.dynamic.multiple.data.source.config;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/24 16:20
 */
public interface MultipleDataSourceProvider {

    Map<String, DataSource> provide();
}
