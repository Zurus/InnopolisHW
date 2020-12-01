package innopolis.lesson15;

import innopolis.lesson15.pojo.Laptop;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorImpl {
    final static Logger logger = Logger.getLogger(Laptop.class.getName());

    private ConnectorImpl() {
    }
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
                //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile","postgres","123");
            }
        } catch (SQLException e) {
            logger.error("Create connection error {}", e);
        }
        return connection;
    }
}
