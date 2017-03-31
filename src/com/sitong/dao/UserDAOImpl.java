package com.sitong.dao;

import com.sitong.db.DB;
import com.sitong.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuSitong on 2017/3/27.
 */
public class UserDAOImpl implements IUserDAO {
    private Connection conn;
    public UserDAOImpl(){
        conn= DB.getConnection();
    }


    @Override
    public boolean add(User user) {
        PreparedStatement pstmt=null;
        boolean flag=false;
        String sql="insert into user(user_name,password) values(?,?)";
        try {
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());

            flag=pstmt.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DB.closeConnection();
        return flag;
    }

    @Override
    public boolean del(int id) {
        PreparedStatement pstm = null;
        boolean flag=false;
        String sql = "delete from user where user_id= ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            flag = pstm.executeUpdate()>0?true:false;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DB.closeConnection();
        }

        return flag;
    }

    @Override
    public boolean update(User user) {
        PreparedStatement pstm = null;
        String sql = "update user set user_name=?,password=?  " +
                "where user_id = ?";
        boolean flag = false;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            pstm.setInt(3,user.getUser_id());

            flag = pstm.executeUpdate()>0?true:false;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DB.closeConnection();
        }

        return flag;


    }

    @Override
    public List<User> queryAll() {
        PreparedStatement pstm = null;
        List<User> list = new ArrayList<User>();
        User user = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM USER ORDER BY user_id DESC ";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DB.closeConnection();
        }

        return list;
    }

    @Override
    public User queryUserByid(int id) {
        PreparedStatement pstm = null;
        User user = null;
        ResultSet rs = null;
        //String sql = "SELECT * FROM USER WHERE USER_ID=?";
        try {
            pstm=conn.prepareStatement("select * from user where  user_id=?");
            pstm.setInt(1,id);

            rs=pstm.executeQuery();

            if(rs.next()){
                user=new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
          //  DB.closeConnection();
        }

        return user;
    }

    @Override
    public User queryUserByName(String name) {
        PreparedStatement pstm = null;
        User user = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM USER WHERE USER_NAME=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,name);
            rs = pstm.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUser_id(user.getUser_id());
                user.setUsername(user.getUsername());
                user.setPassword(user.getPassword());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DB.closeConnection();
        }

        return user;
    }
}
