package com.jiamy.apolearn;

import com.jiamy.apolearn.dto.User;
import com.jiamy.apolearn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/23 16:25
 **/
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User(2L, "Jack", "123456");
        user.setPassword("123456");
        userService.login(user);
    }
}
