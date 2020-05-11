import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    public Drawing(Shape... shapes) {
        this.shapes = Arrays.asList(shapes);
    }

    @Override
    public void paint() {
        this.shapes.forEach(Shape::paint);
    }

}
