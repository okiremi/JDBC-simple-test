package com.learn.jdbc;

import com.learn.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
JDBC API
 */
public class JDBCDemo_ResultSet {
    @Test
    public void testDQL() throws SQLException {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //定义sql
        String sql = "select * from account";
        //获取执行对象
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet resultSet = stmt.executeQuery(sql);
        //遍历resultSet的所有数据
        //一行一行获取数据
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int money = resultSet.getInt(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("----------------");
        }
        //释放资源
        stmt.close();
        resultSet.close();
        conn.close();
    }
    //查询表account数据并封装到Account对象，存储到ArrayList集合
    /*
    * 1.定义实体对象Account
    * 2.查询数据并封装
    * 3.存储
    */
    @Test
    public void testResultSet() throws SQLException {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql:///learning?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select * from account";
        //获取执行对象
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet resultSet = stmt.executeQuery(sql);
        //创建集合
        List<Account> list = new ArrayList<>();
        //遍历resultSet的所有数据
        //一行一行获取数据
        while (resultSet.next()) {
            //实体对象
            Account account = new Account();
            //获得全部数据
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int money = resultSet.getInt(3);
            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            //赋值
            list.add(account);
        }
        //释放资源
        stmt.close();
        resultSet.close();
        conn.close();

        System.out.println(list);
    }
}
