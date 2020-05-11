package structural.decorator;

public abstract class HouseDecorator implements House {

    protected House house;

    public HouseDecorator(House house) {
        this.house = house;
    }

    @Override
    public void build() {
        this.house.build();
    }

}
