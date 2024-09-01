package com.learn.jdbc;

import com.learn.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
* SQL注入
* */
public class JDBCDemo_UserLogin {
    @Test
    public void testDQL() throws SQLException {
        //获取连接
        String url = "jdbc:mysql:///db1?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        //此密码将导致发生sql注入现象
        String name = "hfjdhsb";
        String pwd = "' or '1' = '1";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        //释放资源
        stmt.close();
        rs.close();
        conn.close();
    }
}
