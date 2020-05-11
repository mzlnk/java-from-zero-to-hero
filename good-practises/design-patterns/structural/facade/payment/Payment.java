package structural.facade.payment;

import java.util.UUID;

public class Payment {

    private UUID uuid;
    private double amount;

    public Payment(double amount) {
        this.uuid = UUID.randomUUID();
        this.amount = amount;
    }

}
