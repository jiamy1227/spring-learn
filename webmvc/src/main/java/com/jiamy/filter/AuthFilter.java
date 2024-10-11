package com.jiamy.filter;


import com.jiamy.dto.User;
import com.jiamy.service.UserService;
import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/10 11:28
 **/
@Component
public class AuthFilter implements Filter {

    Logger logger = Logger.getLogger(AuthFilter.class.getName());

    @Autowired
    UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("AuthFilter doFilter....");
        User user = userService.getById("5");
        System.out.println(user.toString());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
