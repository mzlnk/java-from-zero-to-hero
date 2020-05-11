package creational.abstractfactory.shape;

class HeroShapeFactory implements ShapeFactory {

    HeroShapeFactory() {

    }

    @Override
    public Shape getShape(Shape.ShapeType shapeType) {
        return switch (shapeType) {
            case TRIANGLE -> new HeroTriangle();
            case SQUARE -> new HeroSquare();
        };
    }

}
