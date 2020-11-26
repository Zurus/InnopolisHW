package innopolis.lesson15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorImpl {

    private ConnectorImpl() {
    }
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                //connection = DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/mobile","postgres","123");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
