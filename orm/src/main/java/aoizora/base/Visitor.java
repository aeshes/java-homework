package aoizora.base;

import aoizora.types.TraversedArray;
import aoizora.types.TraversedObject;
import aoizora.types.TraversedPrimitive;

public interface Visitor {
    void visit(TraversedPrimitive primitive);
    void visit(TraversedArray array);
    void visit(TraversedObject object);
}
