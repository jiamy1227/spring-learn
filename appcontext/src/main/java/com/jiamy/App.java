package com.jiamy;

import com.jiamy.iocbean.annotation.UserService;
import com.jiamy.iocbean.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.ZoneId;

@Configuration
@ComponentScan
public class App {

    public static void main(String[] args) {
        // 使用xml配置
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        // 注解装配bean
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User(2L, "Jack", "123456");
        user.setPassword("123456");
        userService.login(user);

        ZoneId zoneId = context.getBean(ZoneId.class);
        System.out.println(zoneId);



    }
}
