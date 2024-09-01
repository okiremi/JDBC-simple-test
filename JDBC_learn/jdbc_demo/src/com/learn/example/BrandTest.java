package com.learn.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.learn.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JetBrains\\java project\\JDBC_learn\\jdbc_demo\\src\\com\\learn\\druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();
        //定义sql语句
        String sql = "select * from tb_brand";
        //获取执行对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //定义集合
        List<Brand> brands = new ArrayList<>();
        //处理数据
        while (rs.next()){
            //封装
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int order = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            Brand brand = new Brand(id,brandName,companyName,order,description,status);
            //装载集合
            brands.add(brand);
        }
        System.out.println(brands);
        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
    @Test
    public void testAdd() throws Exception {
        //接收参数
        String brandName = "抖音";
        String companyName = "字节跳动有限公司";
        int orders = 5;
        String description = "抖音，点亮生活每一天";
        int status = 1;
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JetBrains\\java project\\JDBC_learn\\jdbc_demo\\src\\com\\learn\\druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();
        //定义sql语句
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) value(?,?,?,?,?);";
        //获取执行对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,orders);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        //执行sql
        int aff = pstmt.executeUpdate();
        //处理数据
        System.out.println(aff > 0);
        //释放资源
        pstmt.close();
        conn.close();
    }
    @Test
    public void testUpdate() throws Exception {
        //接收参数
        int id = 4;
        String brandName = "抖音";
        String companyName = "字节跳动有限公司";
        int orders = 10;
        String description = "抖音，给你不一样的选择";
        int status = 1;
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JetBrains\\java project\\JDBC_learn\\jdbc_demo\\src\\com\\learn\\druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();
        //定义sql语句（待注入部分用占位符代替）
        String sql = "update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?";
        //获取执行对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,orders);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        //执行sql
        int aff = pstmt.executeUpdate();
        //处理数据
        System.out.println(aff > 0);
        //释放资源
        pstmt.close();
        conn.close();
    }
    @Test
    public void testDelete() throws Exception {
        //接收参数
        int id = 4;
        String brandName = "抖音";
        String companyName = "字节跳动有限公司";
        int orders = 10;
        String description = "抖音，给你不一样的选择";
        int status = 1;
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JetBrains\\java project\\JDBC_learn\\jdbc_demo\\src\\com\\learn\\druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();
        //定义sql语句（待注入部分用占位符代替）
        String sql = "delete from tb_brand where id = ?";
        //获取执行对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        //执行sql
        int aff = pstmt.executeUpdate();
        //处理数据
        System.out.println(aff > 0);
        //释放资源
        pstmt.close();
        conn.close();
    }
}
