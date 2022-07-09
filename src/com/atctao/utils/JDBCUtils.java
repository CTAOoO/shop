package com.atctao.utils;

import com.atctao.dao.impl.CustomersDAOImpl;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 数据库的连接
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            // 1.读取配置文件中的基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            // 2.加载驱动
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static <T> Connection getConnection1(Class<T> clazz){
        Connection conn = null;
        try {
            // 1.读取配置文件中的基本信息
            InputStream is = clazz.class.getClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            // 2.加载驱动
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭连接，Statement
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static class clazz {
    }
}
