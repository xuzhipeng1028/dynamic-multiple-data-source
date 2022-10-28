package com.xzp.dynamic.multiple.data.source.controller;

import com.xzp.dynamic.multiple.data.source.entity.User;
import com.xzp.dynamic.multiple.data.source.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 14:56
 */
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public void test() {
        List<User> users = userService.selectMaster();
        System.out.println(users);
        System.out.println("--------------");
        List<User> users1 = userService.selectSlave();
        System.out.println(users1);
    }
}
