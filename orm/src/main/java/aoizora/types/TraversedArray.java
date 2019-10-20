package aoizora.types;

import aoizora.base.TraversedField;
import aoizora.base.Visitor;

import java.lang.reflect.Field;

public class TraversedArray extends TraversedField {

    private final Object array;

    public TraversedArray(Field field, Object array) {
        super(field);
        this.array = array;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Object getArray() {
        return array;
    }
}
