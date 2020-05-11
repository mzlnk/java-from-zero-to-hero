package creational.abstractfactory.shape;

class CommonShapeFactory implements ShapeFactory {

    CommonShapeFactory() {

    }

    @Override
    public Shape getShape(Shape.ShapeType shapeType) {
        return switch(shapeType) {
            case TRIANGLE -> new CommonTriangle();
            case SQUARE -> new CommonSquare();
        };
    }

}
