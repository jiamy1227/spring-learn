package com.jiamy.jdbc.mapper;

import com.jiamy.jdbc.dto.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/26 9:31
 **/
public interface UserMapper {

    @Select("select * from user where id= #{id}")
    User getUserById(@Param("id") String id);
}
