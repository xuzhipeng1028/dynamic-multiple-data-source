package com.xzp.dynamic.multiple.data.source.config;

import com.xzp.dynamic.multiple.data.source.entity.MyDataSource;
import com.xzp.dynamic.multiple.data.source.service.MyDataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 16:02
 */
@Slf4j
@Component
public class DatabaseMultipleDataSourceProvider implements MultipleDataSourceProvider {

    @Resource
    private MyDataSourceService myDataSourceService;

    @Override
    public Map<String, DataSource> provide() {
        log.info("查询数据库里维护的多数剧源");
        List<MyDataSource> list = myDataSourceService.list();
        if (CollectionUtils.isNotEmpty(list)) {
            for (MyDataSource item : list) {
                DynamicMultipleDataSourceUtil.addDataSource(item.getUk(), item.buildDataSource());
            }
        }
        return null;
    }
}
