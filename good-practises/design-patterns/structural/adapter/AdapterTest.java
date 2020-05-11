package structural.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        Car car = new HeroCar();
        CarSpeedAdapter mphAdapter = new CarSpeedMphAdapter(car);

        System.out.println("Speed: " + car.getSpeed());
        System.out.println("Speed in mph: " + mphAdapter.getSpeed());
    }

}
