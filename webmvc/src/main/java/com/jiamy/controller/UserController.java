package com.jiamy.controller;

import com.jiamy.dto.User;
import com.jiamy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/26 14:42
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService; // field inject

    @GetMapping("/get")
    public ModelAndView getById(@RequestParam("id") String id){
        return new ModelAndView("user").addObject("user", userService.getById(id));

    }

    @GetMapping(value = "getRest",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserRest(){
        return "{\"restSupport\":true}";
    }

    @GetMapping(value = "getStr")
    @ResponseBody
    public String getUserStr(@RequestParam("id") String id){
        return userService.getById(id).toString();
    }

    @GetMapping(value = "getObject", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getUserObject(@RequestParam("id") String id){
        return userService.getById(id);
    }

}
