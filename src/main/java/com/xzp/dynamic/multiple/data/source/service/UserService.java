package com.xzp.dynamic.multiple.data.source.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.dynamic.multiple.data.source.config.MultipleDataSource;
import com.xzp.dynamic.multiple.data.source.entity.User;
import com.xzp.dynamic.multiple.data.source.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 15:34
 */
@Service
@MultipleDataSource("master")
public class UserService extends ServiceImpl<UserMapper, User> {

    //    @MultipleDataSource("master")
    public List<User> selectMaster() {
        return list();
    }

    @MultipleDataSource("slave")
    public List<User> selectSlave() {
        return list();
    }
}
