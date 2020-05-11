public class PrototypeTest {

    public static void main(String[] args) {
        // creating repository from database
        measureTime(ProductRepository::fromDatabase);

        // creating repository based on existing one
        ProductRepository repository = ProductRepository.fromDatabase();
        measureTime(() -> {
            try {
                repository.clone();
            } catch(CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void measureTime(Runnable action) {
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();

        System.out.println("Elapsed time: " + (end - start) + "ns");
    }

}
