package aoizora;

import aoizora.db.ConnectionManager;
import aoizora.domain.Account;
import aoizora.logic.LogVisitor;
import aoizora.orm.service.VisitorService;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Connection connection = ConnectionManager.getConnection();

        Account account = new Account(1, 1000, "test");
        LogVisitor visitor = new LogVisitor();
        VisitorService service = new VisitorService();
        service.process(account, visitor);
    }
}
