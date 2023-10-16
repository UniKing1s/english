package com.englishtrans.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getMySQLConnection(){
        String hostName ="sql12.freesqldatabase.com";
        String dbName = "sql12652748";//"englishdictionary";"sql12652748";
        String userName = "sql12652748";//"sql12652748";//"root" ;
        String password = "iJCrQj1X2G";//"iJCrQj1X2G";//"khoivo99122";
        return getConnection(hostName, dbName, userName, password);
    }
    private static Connection getConnection(String hostName, String dbName, String userName, String password){
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = null;
        // load driver 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if(conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
