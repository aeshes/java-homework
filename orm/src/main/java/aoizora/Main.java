package aoizora;

import aoizora.db.ConnectionManager;
import aoizora.domain.User;
import aoizora.orm.Executor;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        Executor.execUpdate(connection,
                new String[] { "create table user(id integer, name varchar(255), email varchar(255), password varchar(255))"});
        Executor.execUpdate(connection,
                new String[] {
                        "insert into user(id, name, email, password) values (1, 'Haruhi', 'haruhi@gmail.com', '123')"
                });
        User user = Executor.execQuery(connection, "select * from user where id = 1", rs -> {
            rs.next();
            User result = new User();
            result.setId(rs.getInt("id"));
            result.setName(rs.getString("name"));
            result.setEmail(rs.getString("email"));
            result.setPassword(rs.getString("password"));
            return result;
        });
        System.out.println(user);
    }
}
