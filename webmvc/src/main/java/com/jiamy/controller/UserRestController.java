package com.jiamy.controller;

import com.jiamy.dto.User;
import com.jiamy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/10/10 16:21
 **/
@RestController
@RequestMapping("/userRest")
// @CrossOrigin(origins="*")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public User getById(@RequestParam("id") String id, HttpServletRequest request){
        System.out.println(request.getRequestURL());
        System.out.println("http请求Origin："+request.getHeader("Origin"));

        return userService.getById(id);
    }
}
