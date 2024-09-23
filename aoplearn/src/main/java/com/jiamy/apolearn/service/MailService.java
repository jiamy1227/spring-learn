package com.jiamy.apolearn.service;

import com.jiamy.apolearn.dto.User;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class MailService {

    public void sendLoginMail(User user) {

        System.out.println(String.format("hi, %s! you are login at %s", user.getName(), LocalTime.now()));
    }
}
