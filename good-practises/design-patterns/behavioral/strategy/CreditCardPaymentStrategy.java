package behavioral.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private String cardNumber;
    private String expiryDate;
    private String cvc;

    public CreditCardPaymentStrategy(String cardNumber, String expiryDate, String cvc) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
    }

    @Override
    public void makeTransaction(double amount) {
        String message = "Transaction completed with credit card [?,?,?]: ?$"
                .replaceFirst("\\?", this.cardNumber)
                .replaceFirst("\\?", this.expiryDate)
                .replaceFirst("\\?", this.cvc)
                .replaceFirst("\\?", String.valueOf(amount));

        System.out.println(message);
    }

}
