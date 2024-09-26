package com.jiamy.mapper;

import com.jiamy.dto.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/26 15:27
 **/
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User getById(@Param("id") String id);
}
