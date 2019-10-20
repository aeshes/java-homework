package aoizora.logic;

import aoizora.base.Visitor;
import aoizora.types.TraversedArray;
import aoizora.types.TraversedObject;
import aoizora.types.TraversedPrimitive;

public class LogVisitor implements Visitor {

    private String primitives;

    @Override
    public void visit(TraversedPrimitive primitive) {
        System.out.println("Primitive: " + primitive.getName());

        primitives = primitives == null ? primitive.getName() : primitives + ", " + primitive.getName();
    }

    @Override
    public void visit(TraversedArray array) {
        System.out.println("Array: " + array.getName());
    }

    @Override
    public void visit(TraversedObject object) {
        System.out.println("Object: " + object.getName());
    }

    public String getPrimitives() {
        return primitives;
    }
}
