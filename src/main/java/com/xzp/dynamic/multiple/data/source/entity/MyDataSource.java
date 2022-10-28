package com.xzp.dynamic.multiple.data.source.entity;

import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.io.Serializable;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 16:10
 */
@Data
public class MyDataSource implements Serializable {
    private static final long serialVersionUID = 2318248802386491049L;

    private Long id;
    private String uk;
    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String pwd;

    @SneakyThrows
    @SuppressWarnings({"unchecked"})
    public DataSource buildDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        Class<DataSource> aClass = (Class<DataSource>) Class.forName(this.type);
        builder.type(aClass);
        builder.driverClassName(this.getDriverClassName());
        builder.username(this.getUsername());
        builder.password(this.getPwd());
        builder.url(this.getUrl());
        return builder.build();
    }
}
