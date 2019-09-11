package aoizora.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

    public static <T> T execQuery(Connection connection, String sql, ResultHandler<T> handler) {

        T result = null;

        try (Statement st = connection.createStatement()) {
            st.execute(sql);
            ResultSet rs = st.getResultSet();
            result = handler.handle(rs);
            rs.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public static void execUpdate(Connection connection, String[] updates) {
        try
        {
            for (String update: updates) {
                Statement st = connection.createStatement();
                st.execute(update);
                st.close();
            }
            connection.commit();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
