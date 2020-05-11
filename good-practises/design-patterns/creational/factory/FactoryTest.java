import factory.shape.Shape;
import factory.shape.ShapeFactory;

public class FactoryTest {

    public static void main(String[] args) {
        Shape triangle = ShapeFactory.getShape(ShapeFactory.ShapeType.TRIANGLE);
        Shape square = ShapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);

        System.out.println("Triangle field formula: " + triangle.getFieldFormula());
        System.out.println("Square field formula: " + square.getFieldFormula());

        // we cannot create Square object explicitly as both constructor and class have package access
        // Square square = new Square();

    }

}
