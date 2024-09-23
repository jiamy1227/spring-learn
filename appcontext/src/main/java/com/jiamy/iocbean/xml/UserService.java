package com.jiamy.iocbean.xml;

import com.jiamy.iocbean.dto.User;

public class UserService {

    MailService mailService;

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void login(){
        System.out.println("login start.....");
        User user = new User("zhajng", 25);
        user.setPassword("123456");

        mailService.sendLoginMail(user);

        System.out.println("login end.....");
    }
}
