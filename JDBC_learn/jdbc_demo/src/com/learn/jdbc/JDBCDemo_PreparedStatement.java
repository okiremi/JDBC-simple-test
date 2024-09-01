package com.learn.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo_PreparedStatement {
    @Test
    public void testDQL() throws SQLException {
        //获取连接
        //通过useServerPrepStmts进行预编译
        String url = "jdbc:mysql:///db1?serverTimezone=UTC&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);

        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        //参数值用占位符替代
        String sql = "select * from tb_user where username = ? and password = ?";
        //使用PreparedStatement可阻止sql注入
        //获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数值，占位符编号和注入内容
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        //释放资源
        pstmt.close();
        rs.close();
        conn.close();
    }
}
