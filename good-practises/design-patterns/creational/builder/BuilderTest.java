package creational.builder;


public class BuilderTest {

    public static void main(String[] args) {
        Address address = new Address.AddressBuilder("US", "San Francisco", "10th Street")
                .withFlatNumber(110)
                .withSecondaryAddress(true)
                .build();

        System.out.println(address);
    }

}
