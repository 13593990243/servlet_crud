package com.guo.service;

import com.guo.dao.UserDao;
import com.guo.entity.User;
import com.guo.uilts.DateUtil;

import java.util.ArrayList;

/**
 * @author guosx
 * @date 2021/2/25
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public ArrayList<User> findByNameAndPs(User user) {
        ArrayList<User> list = userDao.findByNameAndPs(user);
        return list;
    }

    public ArrayList<User> listAll() {
        ArrayList<User> users = userDao.listAll();
        return users;
    }

    public void addUser(User user) {
        String time = DateUtil.getTime();
        user.setCreateTime(time);
        userDao.addUser(user);
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }


    public User findById(Integer id) {
        User byId = userDao.findById(id);
        return byId;
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
