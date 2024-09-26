package com.jiamy.jdbc.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/25 10:01
 **/
public abstract class AbstractDao<T> extends JdbcDaoSupport {

    private String table;

    private Class<T> entityClass;

    private RowMapper<T> rowMapper;

    public AbstractDao() {
        //this.entityClass = getParameterizedType();
        this.table = this.entityClass.getSimpleName().toLowerCase();

        this.rowMapper = rowMapper;
    }
}
