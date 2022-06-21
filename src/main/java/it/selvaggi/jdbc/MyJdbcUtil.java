package it.selvaggi.jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * Utility class for db connection
 * @author Pasquale Selvaggi
 */
public class MyJdbcUtil {

    private static String url = "jdbc:mysql://localhost:3306/newdb";
    private static String user = "developer";
    private static String password = "devpass";
    public static Connection connection;

    private MyJdbcUtil(){}

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        connection = null;
        try{
            // create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static boolean updateQuery(String query){
        try (Connection conn = MyJdbcUtil.getConnection()) {
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Student> studentQuery(String query){
        try (Connection conn = MyJdbcUtil.getConnection()) {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Student> listStudent = new ArrayList<>();
            while(rs.next()){
                listStudent.add(new Student(rs.getString("first_name"),rs.getString("last_name")));
            }
            return listStudent;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }



}
