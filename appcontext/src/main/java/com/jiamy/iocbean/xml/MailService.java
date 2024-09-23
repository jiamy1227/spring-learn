package com.jiamy.iocbean.xml;

import com.jiamy.iocbean.dto.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalTime;

public class MailService {

    DataSource dataSource;

    public void sendLoginMail(User user) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareCall("select * from user where name=? and password=? ");
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            String password ="";
            while(resultSet.next()){
                password = resultSet.getString("password");
            }
            if (password.equals(user.getPassword())) {
                System.out.println(String.format("hi, %s! you are login at %s", user.getName(), LocalTime.now()));
            } else {
                System.out.println(String.format("%s login failed, at %s ", user.getName(), LocalTime.now()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
