package abstractfactory.shape;

class CommonSquare implements Shape {

    CommonSquare() {

    }

    @Override
    public void paint() {
        System.out.println("Just a common square...");
    }

}
