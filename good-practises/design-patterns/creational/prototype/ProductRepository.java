import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductRepository implements Cloneable {

    private Map<UUID, Product> products = new HashMap<>();

    public static ProductRepository fromDatabase() {
        ProductRepository repository = new ProductRepository();

        repository.registerProduct(new Product(UUID.randomUUID(), "Apple", 1000));
        repository.registerProduct(new Product(UUID.randomUUID(), "Orange", 2500));
        repository.registerProduct(new Product(UUID.randomUUID(), "Banana", 1500));

        // assume we pull data from database and it takes some time
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository;
    }

    private ProductRepository() {

    }

    private void registerProduct(Product product) {
        this.products.put(product.getUuid(), product);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ProductRepository repository = new ProductRepository();

        for(Product product : this.products.values()) {
            repository.registerProduct((Product) product.clone());
        }

        return repository;
    }
}
