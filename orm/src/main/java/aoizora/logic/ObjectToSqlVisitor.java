package aoizora.logic;

import aoizora.base.Visitor;
import aoizora.types.TraversedArray;
import aoizora.types.TraversedObject;
import aoizora.types.TraversedPrimitive;

public class ObjectToSqlVisitor implements Visitor {

    private String fieldsList;
    private String valuesList;

    @Override
    public void visit(TraversedPrimitive primitive) {
        fieldsList = fieldsList == null ? primitive.getName() : fieldsList + ", " + primitive.getName();
    }

    @Override
    public void visit(TraversedArray array) {

    }

    @Override
    public void visit(TraversedObject object) {

    }
}
