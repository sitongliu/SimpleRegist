package com.sitong.servise;

import com.sitong.dao.UserDAOImpl;
import com.sitong.vo.User;

import java.util.List;

/**
 * Created by LiuSitong on 2017/3/27.
 */
public class UserServImpl implements IUserServ {
    UserDAOImpl userDao = new UserDAOImpl();

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean del(int id) {
        return userDao.del(id);

    }

    @Override
    public boolean update(User user) {

        return userDao.update(user);
    }

    @Override
    public List<User> queryAll() {

        return userDao.queryAll();
    }

    @Override
    public User queryUserByid(int id) {

        return userDao.queryUserByid(id);
    }

    @Override
    public User queryUserByName(String name) {

        return userDao.queryUserByName(name);
    }
}
