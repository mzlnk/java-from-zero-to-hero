package creational.singleton;

public class HeroSingleton {

    public static HeroSingleton getInstance() {
        return HeroSingletonHelper.INSTANCE;
    }

    private HeroSingleton() {

    }

    private static class HeroSingletonHelper {

        private static final HeroSingleton INSTANCE = new HeroSingleton();

    }

}
