package structural.adapter;

public class CarSpeedMphAdapter implements CarSpeedAdapter {

    private Car car;

    public CarSpeedMphAdapter(Car car) {
        this.car = car;
    }

    @Override
    public double getSpeed() {
        return convertSpeedToMph(this.car.getSpeed());
    }

    private static double convertSpeedToMph(double speed) {
        return speed * 0.621371;
    }

}
