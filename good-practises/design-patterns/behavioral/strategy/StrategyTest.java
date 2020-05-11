public class StrategyTest {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("John Smiths", 980.45D);

        invoice.makeTransaction(new CashPaymentStrategy());
        invoice.makeTransaction(new CreditCardPaymentStrategy("3900-1883", "08/26", "091"));
    }

}
