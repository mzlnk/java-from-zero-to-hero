public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public void makeTransaction(double amount) {
        System.out.println("Transaction completed with cash: " + amount + "$");
    }

}
