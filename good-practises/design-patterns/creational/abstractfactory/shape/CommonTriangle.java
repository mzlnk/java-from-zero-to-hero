package creational.abstractfactory.shape;

class CommonTriangle implements Shape {

    CommonTriangle() {

    }

    @Override
    public void paint() {
        System.out.println("Just a common triangle...");
    }

}
