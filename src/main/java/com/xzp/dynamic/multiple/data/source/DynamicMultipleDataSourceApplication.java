package com.xzp.dynamic.multiple.data.source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {})
@MapperScan("com.xzp.dynamic.multiple.data.source.mapper")
public class DynamicMultipleDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicMultipleDataSourceApplication.class, args);
    }

}
