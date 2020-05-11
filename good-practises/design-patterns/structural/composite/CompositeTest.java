public class CompositeTest {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        Shape drawing = new Drawing(circle, square);

        circle.paint();
        square.paint();

        System.out.println("Painting all drawing:");
        drawing.paint();
    }

}
