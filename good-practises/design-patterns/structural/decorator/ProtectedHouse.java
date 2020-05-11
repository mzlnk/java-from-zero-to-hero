package structural.decorator;

public class ProtectedHouse extends HouseDecorator {

    public ProtectedHouse(House house) {
        super(house);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding some house protection...");
    }

}
