package aoizora.types;

import aoizora.base.TraversedField;
import aoizora.base.Visitor;

import java.lang.reflect.Field;

public class TraversedPrimitive extends TraversedField {

    public TraversedPrimitive(Field field) {
        super(field);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
