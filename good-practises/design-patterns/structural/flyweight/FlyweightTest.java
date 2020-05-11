package structural.flyweight;

import structural.flyweight.formatter.DocumentFormatter;
import structural.flyweight.formatter.DocumentFormatterFactory;

public class FlyweightTest {

    public static void main(String[] args) {
        Document document = new Document("Some content...");

        for(int i = 0; i < 5; i++) {
            measureTime(() -> {
                DocumentFormatter formatter = DocumentFormatterFactory.getFormatter(DocumentFormatter.Type.PDF);
                formatter.format(document);
            });
        }
    }

    private static void measureTime(Runnable action) {
        long start = System.nanoTime();

        action.run();

        long end = System.nanoTime();
        System.out.println("Elapsed time: " + (end - start) + "ns");
    }

}
