package com.util;

import java.sql.*;

public class DbUtils {
    //加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/employee?userUnicode=true&characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void Close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭statement连接
     *
     * @param statement 连接
     */
    public static void Close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭connection和statement连接
     *
     * @param connection 连接
     */
    public static void Close(Connection connection, Statement statement) {
        Close(statement);
        Close(connection);
    }


    /**
     * 增删改的通用操作
     *
     * @param sql    需要执行的sql语句
     * @param params 条件参数
     * @return 返回受影响的行数
     */
    public static int executeUpdate(String sql, Object... params) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        int rows = -1;
        if (connection == null) {
            return rows;
        }
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            rows = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            Close(connection, statement);
        }
        return rows;
    }


    public static ResultSet executeQuery(String sql, Object... params) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection == null) {
            return null;
        }
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            resultSet = statement.executeQuery();
            connection.commit();
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Close(connection, statement);
            }
        }
        return resultSet;
    }


}
