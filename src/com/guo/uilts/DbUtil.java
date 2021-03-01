package com.guo.uilts;

import java.sql.*;

/**
 * @auth admin
 * @date
 * @Description
 */
public class DbUtil {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/servlet_crud?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement prep, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prep != null) {
                prep.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement prep, Connection conn) {
        try {
            if (prep != null) {
                prep.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
