package com.learn.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
JDBC API
 */
public class JDBCDemo_Statement {
    @Test
    public void testDML() throws SQLException {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //定义sql
        String sql = "update emp set salary = 15000 where id = 200";
        //获取sql执行对象
        java.sql.Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);//受影响行数
        //处理返回结果
        //System.out.println(count);
        if (count > 0){
            System.out.println("修改成功");
        } else if (count == 0) {
            System.out.println("错误");
        }
        //释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws SQLException {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //定义sql
        String sql = "drop database db2";
        //获取sql执行对象
        java.sql.Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);//受影响行数
        //处理返回结果
        //System.out.println(count);
        if (count > 0){
            System.out.println("修改成功");
        } else if (count == 0) {
            System.out.println("错误");
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
