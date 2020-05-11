package creational.abstractfactory.shape;

class HeroSquare implements Shape {

    HeroSquare() {

    }

    @Override
    public void paint() {
        System.out.println("It's a Hero Square!");
    }

}
