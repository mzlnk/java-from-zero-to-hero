package behavioral.strategy;

import java.util.UUID;

public class Invoice {

    private UUID uuid = UUID.randomUUID();
    private String owner;
    private double amount;

    public Invoice(String owner, double amount) {
        this.owner = owner;
        this.amount = amount;
    }

    public void makeTransaction(PaymentStrategy paymentStrategy) {
        paymentStrategy.makeTransaction(this.amount);
    }

}
