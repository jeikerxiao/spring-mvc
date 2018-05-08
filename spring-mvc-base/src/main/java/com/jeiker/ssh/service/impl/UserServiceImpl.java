package com.jeiker.ssh.service.impl;

import com.jeiker.ssh.dao.UserDao;
import com.jeiker.ssh.model.User;
import com.jeiker.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User load(Integer id) {
        return userDao.load(id);
    }

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void persist(User entity) {
        userDao.persist(entity);
    }

    @Override
    public Integer save(User entity) {
        return userDao.save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        userDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void flush() {
        userDao.flush();
    }
}
