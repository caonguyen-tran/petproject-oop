package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/database";
        final String user = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void disconnect(Connection connect){
        if(connect != null){
            try {
                connect.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
