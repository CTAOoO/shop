package com.atctao.dao;

import com.atctao.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    private Class<T> clazz = null;
    {
        // 获取当前BaseDAO的子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] types = parameterizedType.getActualTypeArguments();// 获取父类的泛型
        clazz = (Class<T>) types[0];//泛型的第一个参数
    }
    public int update(Connection conn,String sql,Object ...args){//sql中占位符的个数与可变形参的长度相同
        PreparedStatement ps =null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps);
        }
        return -1;
    }
    /**
     * 查询返回一个javaBean的sql语句
     * @param sql 执行的sql语句
     * @param args sql的对应的参数值
     * @return
     */
    public T queryForOne(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            // ResultSetMetaData获取结果集的列数
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()){
                T t = clazz.newInstance();
                // 处理结果集一行的每一列数据
                for (int i=0;i<columnCount;i++){
                    // 获取列值
                    Object columnValue = resultSet.getObject(i+1);
                    // 获取每个列的列名
//                    String columnName = resultSetMetaData.getColumnName(i+1);
                    // 获取每个列的别名
                    String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                    // 给t对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,resultSet);
        }
        return null;
    }

    /**
     * 查询返回多个
     * @param sql
     * @param args
     * @return
     */
    public List<T> queryForList(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            // ResultSetMetaData获取结果集的列数
            int columnCount = resultSetMetaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()){
                T t = clazz.newInstance();
                // 处理结果集一行的每一列数据
                for (int i=0;i<columnCount;i++){
                    // 获取列值
                    Object columnValue = resultSet.getObject(i+1);
                    // 获取每个列的列名
//                    String columnName = resultSetMetaData.getColumnName(i+1);
                    // 获取每个列的别名
                    String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                    // 给t对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,resultSet);
        }
        return null;
    }
    //用于查询特殊值的泛类方法
    public <E> E getValue(Connection conn,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,resultSet);
        }
        return null;
    }

}
