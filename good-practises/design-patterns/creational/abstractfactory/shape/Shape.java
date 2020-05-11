package creational.abstractfactory.shape;

public interface Shape {

    void paint();

    enum ShapeType {

        TRIANGLE,
        SQUARE;

    }

}
