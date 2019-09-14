package aoizora;

import aoizora.base.Visitor;
import aoizora.db.ConnectionManager;
import aoizora.domain.Account;
import aoizora.logic.LogVisitor;
import aoizora.types.TraversedArray;
import aoizora.types.TraversedPrimitive;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Connection connection = ConnectionManager.getConnection();

        Account account = new Account(1, 1000, "test");
        LogVisitor visitor = new LogVisitor();
        traverse(account, visitor);
        System.out.println(visitor.getPrimitives());
    }

    private static void traverse(Object object, Visitor visitor) throws IllegalAccessException {

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);

            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            if (field.getType().isPrimitive()) {
                new TraversedPrimitive(field).accept(visitor);
            }
            else if (field.getType().isArray()) {
                new TraversedArray(field, field).accept(visitor);
            }
            else {
                traverse(field.get(object), visitor);
            }
        }
    }
}
