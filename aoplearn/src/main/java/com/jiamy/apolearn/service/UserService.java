package com.jiamy.apolearn.service;

import com.jiamy.apolearn.annotation.MetricTime;
import com.jiamy.apolearn.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("app.properties")
public class UserService {

    @Autowired
    MailService mailService;


    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @MetricTime("login")
    public void login(User user) throws InterruptedException {
        Thread.sleep(1000);
        mailService.sendLoginMail(user);

    }
}
