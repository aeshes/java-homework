package aoizora.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:h2:mem:testdb";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            connection.setAutoCommit(true);
            return connection;
        }
        catch (SQLException ignore) { }

        return null;
    }
}
