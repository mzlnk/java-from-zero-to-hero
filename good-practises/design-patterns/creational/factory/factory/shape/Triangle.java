package factory.shape;

class Triangle implements Shape {

    Triangle() {

    }

    @Override
    public String getFieldFormula() {
        return "(a * h) / 2";
    }

}
