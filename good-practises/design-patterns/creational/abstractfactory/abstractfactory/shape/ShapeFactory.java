package abstractfactory.shape;

public interface ShapeFactory {

    Shape getShape(Shape.ShapeType shapeType);

    enum ShapeFactoryType {

        COMMON,
        HERO;

    }

}
