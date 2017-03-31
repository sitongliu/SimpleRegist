package com.sitong.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/27.
 */
public class DB {
    private static Connection conn;
    public static Connection  getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users?useUnicode=true&characterEncoding=utf-8","root","root") ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
