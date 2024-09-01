package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC API
 */
public class JDBCDemo_Connection {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //定义sql
        String sql_1 = "update emp set salary = 12000 where id = 2";
        String sql_2 = "update emp set salary = 12000 where id = 5";
        //获取sql执行对象
        Statement stmt = conn.createStatement();
        try {
            //开启事务，手动提交
            conn.setAutoCommit(false);
            //事务1
            //执行sql
            int count_1 = stmt.executeUpdate(sql_1);//受影响行数
            //处理返回结果
            System.out.println(count_1);
            //异常状况
            //int i = 3/0;
            //事务2
            int count_2 = stmt.executeUpdate(sql_2);
            System.out.println(count_2);
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            //回滚事务
            throw new RuntimeException(e);
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
