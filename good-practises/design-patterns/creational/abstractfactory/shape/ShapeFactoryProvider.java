package creational.abstractfactory.shape;

import java.util.EnumMap;
import java.util.Map;

public class ShapeFactoryProvider {

    private static final Map<ShapeFactory.ShapeFactoryType, ShapeFactory> factories = new EnumMap<>(ShapeFactory.ShapeFactoryType.class);

    static {
        factories.put(ShapeFactory.ShapeFactoryType.COMMON, new CommonShapeFactory());
        factories.put(ShapeFactory.ShapeFactoryType.HERO, new HeroShapeFactory());
    }

    public static ShapeFactory getFactory(ShapeFactory.ShapeFactoryType factoryType) {
        return factories.get(factoryType);
    }

}
