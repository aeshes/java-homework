package aoizora.types;

import aoizora.base.TraversedField;
import aoizora.base.Visitor;

import java.lang.reflect.Field;

public class TraversedObject extends TraversedField {

    public TraversedObject(Field field) {
        super(field);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
