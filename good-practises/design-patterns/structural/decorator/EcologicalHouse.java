public class EcologicalHouse extends HouseDecorator {

    public EcologicalHouse(House house) {
        super(house);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding some ecological features...");
    }

}
