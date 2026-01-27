package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pubs";
        String username = "root";
        String password = "n3u3da!";

        try {
            Class.forName(driver);
            //connection
            Connection con =  DriverManager.getConnection(url, username,password);
            //set up interface
            Statement statement = con.createStatement();
            String sql = "INSERT INTO person VALUES(101,'rajini', 'thalaivar@gmail.com')";
//            statement.executeUpdate(sql);
            int noRec = statement.executeUpdate(sql);
            if (noRec > 0){
                System.out.println("Done");
            }
            else{
                System.out.println("Failed");
            }
            statement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
