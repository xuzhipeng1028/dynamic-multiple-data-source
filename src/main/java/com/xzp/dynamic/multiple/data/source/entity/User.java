package com.xzp.dynamic.multiple.data.source.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 15:32
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6693443234465550247L;

    private Long id;
    private String name;
}
