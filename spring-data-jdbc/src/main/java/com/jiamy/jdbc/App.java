package com.jiamy.jdbc;

import com.jiamy.jdbc.dto.User;
import com.jiamy.jdbc.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/24 15:40
 **/
@Component
@ComponentScan
@EnableTransactionManagement
@MapperScan("com.jiamy.*.mapper")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.getUserById("1");
        System.out.println(user.toString());

        User user2 = userService.getUserByName("Tom");
        System.out.println(user2.toString());

        System.out.println("list user...");
        List<User> userLsit = userService.getUsers();
        for (User u: userLsit) {
            System.out.println(u.toString());
        }

        userService.updateUserByName("jiamy", "1049465510@qq.com");

        userService.deleteById(6L);

        System.out.println("test transactionManager");
        userService.updateByName("jiamy");

        System.out.println("test transactionManager2");
        userService.updateByNameTx2("jiamy");

        System.out.println("mybatis ......");
        System.out.println(userService.getUserBYMapper("7").toString());


    }
}
