package com.dbPack;
import java.sql.*;

public class dbConn {
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException cnfE) {
            cnfE.printStackTrace();
        }
        Connection conn = null;
        String url = "jdbc:sqlite:DBjadwal.sqlite";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }/*finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/
        return conn;
    }

}
