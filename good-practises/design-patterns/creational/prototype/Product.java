import java.util.UUID;

public class Product implements Cloneable {

    private UUID uuid;
    private String name;
    private long quantity;

    public Product(UUID uuid, String name, long quantity) {
        this.uuid = uuid;
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public long getQuantity() {
        return this.quantity;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Product(this.uuid, this.name, this.quantity);
    }
}
