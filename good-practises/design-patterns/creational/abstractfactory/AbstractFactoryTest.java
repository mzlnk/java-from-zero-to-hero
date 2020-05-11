package creational.abstractfactory;

import creational.abstractfactory.shape.Shape;
import creational.abstractfactory.shape.ShapeFactory;
import creational.abstractfactory.shape.ShapeFactoryProvider;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        ShapeFactory factory;

        factory = ShapeFactoryProvider.getFactory(ShapeFactory.ShapeFactoryType.COMMON);
        factory.getShape(Shape.ShapeType.TRIANGLE).paint();

        factory = ShapeFactoryProvider.getFactory(ShapeFactory.ShapeFactoryType.HERO);
        factory.getShape(Shape.ShapeType.TRIANGLE).paint();
    }

}
