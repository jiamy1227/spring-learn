package com.jiamy.jdbc.service;

import com.jiamy.jdbc.dto.User;
import com.jiamy.jdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/24 16:03
 **/
@Component
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager txManager;
    @Autowired
    UserMapper userMapper;

    /**
     * jdbcTemplate.queryForObject
     * @param id
     * @return
     */
    public User getUserById(String id) {
        return jdbcTemplate.queryForObject("select * from user where id= ?", (ResultSet rs, int rowNum) -> {
            User user  = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }, id);
    }

    public User getUserByName(String name){
        List<User> users =  jdbcTemplate.query("select * from user where name= ?",(ResultSet rs, int rowNum) -> {
            User user  = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }, name);
        if(CollectionUtils.isEmpty(users)) {
            return new User();
        } else {
            return users.get(0);
        }
    }

    public List<User> getUsers(){
        return jdbcTemplate.query("select * from user",(ResultSet rs, int rowNum) -> {
            User user  = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }

    public int updateUserByName(String name, String email){
        return jdbcTemplate.update("update user set email=? where name= ?", email, name);
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from User where id=?", id);
    }

    public int updateByName(String name){
        // 开启事务
        TransactionStatus tx = null;
        int result = 0;
        try {
            tx = txManager.getTransaction(new DefaultTransactionDefinition());
            result = jdbcTemplate.update("update user set email=? where name= ?", "jiamy1227", "jiamy");
            // sqlException
            //jdbcTemplate.update("update user123 set email=? where name= ?", "jiamy1227", "jiamy");
            txManager.commit(tx);
        } catch (Exception e) {
            txManager.rollback(tx);
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateByNameTx2(String name) {
        int result = 0;

        result = jdbcTemplate.update("update user set email=? where name= ?", "Billie2", "jiamy");
        // sqlException
        //jdbcTemplate.update("update user123 set email=? where name= ?", "Sandy", "jiamy");
        return result;
    }

    public User getUserBYMapper(String id){
        return userMapper.getUserById(id);
    }
}
