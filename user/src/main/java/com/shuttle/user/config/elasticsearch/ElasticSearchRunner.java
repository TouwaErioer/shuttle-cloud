package com.shuttle.user.config.elasticsearch;

import com.shuttle.user.entity.User;
import com.shuttle.user.repository.UserRepository;
import com.shuttle.user.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 启动初始化es数据
 * @author: DHY
 * @created: 2021/02/28 15:25
 */
@Component
public class ElasticSearchRunner implements ApplicationRunner {

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {
        userImportAll();
    }

    public void userImportAll() {
        List<User> products = userService.findAll(new HashMap<>()).getList();
        userRepository.saveAll(products);
    }
}
