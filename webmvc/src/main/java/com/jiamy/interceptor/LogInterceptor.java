package com.jiamy.interceptor;

import com.jiamy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/10 15:23
 **/
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("do pre interceptor :" + request.getRequestURL());

        System.out.println(userService.getById("5").toString());

        return true;
    }
}
