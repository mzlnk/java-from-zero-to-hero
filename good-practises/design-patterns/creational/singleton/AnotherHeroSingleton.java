public class AnotherHeroSingleton {

    private static AnotherHeroSingleton INSTANCE;

    public static AnotherHeroSingleton getInstance() {
        if(INSTANCE == null) {
            synchronized (AnotherHeroSingleton.class) {
                if(INSTANCE == null) {
                    INSTANCE = new AnotherHeroSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
