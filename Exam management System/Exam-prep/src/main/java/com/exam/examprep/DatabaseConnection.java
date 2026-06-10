//package com.exam.examprep;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String DB_HOST = "localhost";
//    private static final String DB_NAME = "exam_prep";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "12345678";
////    private static final String DB_URL = "jdbc:mysql://"+DB_HOST+"/"+DB_NAME;
//    private static final String DB_URL =
//        "jdbc:mysql://localhost:3306/exam_prep";
//
//    private static Connection connection;
//
//    private DatabaseConnection(){
//        try{
//            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
//            System.out.println(connection);
//            System.out.println("Connect to the database");
//
//        }catch(SQLException ex){
//            ex.printStackTrace();
//            System.out.println("Failed to connect to database");
//        }
//    }
//    public static Connection getConnection(){
//        if (connection == null){
//            new DatabaseConnection();
//        }
//        System.out.println("Inside the getConnection function");
//        return connection;
//    }
//
//}

package com.exam.examprep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL =
            "jdbc:mysql://127.0.0.1:3306/exam_prep";

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rafin2312";

    private static Connection connection = null;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        DB_URL,
                        DB_USERNAME,
                        DB_PASSWORD
                );

                System.out.println("Database Connected Successfully");
            }

        } catch (ClassNotFoundException ex) {

            System.out.println("MySQL JDBC Driver Not Found");
            ex.printStackTrace();

        } catch (SQLException ex) {

            System.out.println("Database Connection Failed");
            ex.printStackTrace();

        }

        return connection;
    }
}