package aoizora.orm.service;

import aoizora.base.Visitor;
import aoizora.types.TraversedArray;
import aoizora.types.TraversedPrimitive;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class VisitorService {

    public void process(Object object, Visitor visitor) {
        try {
            traverse(object, visitor);
        }
        catch (IllegalAccessException e) {}
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
