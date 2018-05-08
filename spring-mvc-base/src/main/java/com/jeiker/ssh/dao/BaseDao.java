package com.jeiker.ssh.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 这个接口定义一些十分通用的方法
 * Created by xiao
 * On 11/16/2017.11:52 PM
 */
public interface BaseDao<T, PK extends Serializable> {
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}