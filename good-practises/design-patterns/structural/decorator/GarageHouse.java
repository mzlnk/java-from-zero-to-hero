package structural.decorator;

public class GarageHouse extends HouseDecorator {

    public GarageHouse(House house) {
        super(house);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding a garage...");
    }
}
