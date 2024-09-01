package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
JDBC入门
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //定义sql
        String sql = "update emp set salary = 15000 where id = 2";
        //获取sql执行对象
        Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);//受影响行数
        //处理返回结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();
    }
}
