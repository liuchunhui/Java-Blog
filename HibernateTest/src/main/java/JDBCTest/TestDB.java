package JDBCTest;

import java.io.IOException;
import java.sql.*;

/**
* Created by huihui on 14-11-7.
*/
public class TestDB {
    public static void main(String[] args) throws IOException {
        try {
            runTest();
        }catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }
    }

    public static void runTest() throws SQLException,IOException {

        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            throw new ClassNotFoundException("发生ClassNotFoundException");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        Connection conn = getConnection();

        Statement stat = conn.createStatement();

        //stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
        stat.executeUpdate("INSERT INTO  Greetings VALUES('Hello,Word!')");

        ResultSet result = stat.executeQuery("SELECT * FROM Greetings");

        if (result.next()) {
            System.out.println(result.getString(1));
        }

        //stat.executeUpdate("DROP TABLE Greetings");

    }

    public static Connection getConnection() throws SQLException,IOException {


        String url = "jdbc:mysql://localhost:3306/hibernate?useUnicode=true&amp;characterEncoding=utf8";
        String username = "root";
        String password = "0000";


        return DriverManager.getConnection(url,username,password);



    }
}
