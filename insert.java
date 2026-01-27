package org.example;

import java.sql.*;

public class INUPDEL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "n3u3da!";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

             System.out.println("inserting rec");

             String insertSql = "INSERT INTO why VALUES(101, 'Rajini', 'rajini@gmail.com')";
             int rowsInserted = stmt.executeUpdate(insertSql);

             insertSql = "INSERT INTO why VALUES(102, 'Kamal', 'ulaganayagan@gmail.com')";
             rowsInserted = stmt.executeUpdate(insertSql);

             if (rowsInserted > 0) {
                System.out.println("Insert Successful!");
             } else {
                System.out.println("Insert Failed!");
             }

             System.out.println("\nRecords after insertion");
             displayRecords(stmt);

             System.out.println("\n Deleting Record");
             String deleteSql = "DELETE FROM why WHERE id = 101";
             int rowsDeleted = stmt.executeUpdate(deleteSql);
             if (rowsDeleted > 0) System.out.println("Delete Successful!");

             System.out.println("\nRecords after Deletion");
             displayRecords(stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayRecords(Statement stmt) throws SQLException {
        String selectSql = "SELECT * FROM why";
        try (ResultSet rs = stmt.executeQuery(selectSql)) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        }
    }
}