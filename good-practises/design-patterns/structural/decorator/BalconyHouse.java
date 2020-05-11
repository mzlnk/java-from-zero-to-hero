package structural.decorator;

public class BalconyHouse extends HouseDecorator {

    public BalconyHouse(House house) {
        super(house);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding a balcony...");
    }

}
