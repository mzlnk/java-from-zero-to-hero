public class DecoratorTest {

    public static void main(String[] args) {
        House house = new BalconyHouse(
                new GarageHouse(
                        new BasicHouse()
                )
        );

        House heroHouse = new EcologicalHouse(
                new BalconyHouse(
                        new ProtectedHouse(
                                new GarageHouse(
                                        new ProtectedHouse(
                                                new BasicHouse()
                                        )
                                )
                        )
                )
        );

        System.out.println("Building house:");
        house.build();

        System.out.println("Build hero house:");
        heroHouse.build();

    }

}
