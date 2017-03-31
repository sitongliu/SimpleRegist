package com.sitong.servise;

import com.sitong.vo.User;

import java.util.List;

/**
 * Created by LiuSitong on 2017/3/27.
 */
public interface IUserServ {
    public boolean add(User user);
    public boolean del(int id);
    public boolean update(User user);
    public List<User> queryAll();
    public User queryUserByid(int id);
    public User queryUserByName(String name);

}
