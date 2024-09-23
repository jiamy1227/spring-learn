package com.jiamy.iocbean.annotation;

import com.jiamy.iocbean.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

@Component
public class MailService {

    @Autowired
    List<DataSource> dataSource;

    public void sendLoginMail(User user, String smtpHost) {

        int order = (int) (user.getId() % 2);

        try(Connection connection = dataSource.get(order).getConnection()){
            PreparedStatement preparedStatement = connection.prepareCall("select * from user where name=? and password=? ");
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            String password ="";
            while(resultSet.next()){
                password = resultSet.getString("password");
            }
            if (password.equals(user.getPassword())) {
                System.out.println(String.format("hi, %s! you are login at %s %s", user.getName(), LocalTime.now(), smtpHost));
            } else {
                System.out.println(String.format("%s login failed, at %s ", user.getName(), LocalTime.now()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
