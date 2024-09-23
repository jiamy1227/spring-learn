package com.jiamy.iocbean.annotation;

import com.jiamy.iocbean.dto.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
//@PropertySource("app.properties")
public class UserService {

    @Autowired
    MailService mailService;

    @Value(value = "classpath:app.properties")
    Resource resource;

    @Value("#{smtpConfig.host}")
    String smtpHost;

    // @PostConstruct
    public void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if(line.startsWith("smtp.host")){
                smtpHost = line.replace("smtp.host=","");
            }
        }
    }


    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void login(User user){
        System.out.println("login start.....");

        mailService.sendLoginMail(user, smtpHost);

        System.out.println("login end.....");
    }
}
