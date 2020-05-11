package structural.facade.payment;

public class PaymentFacade {

    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private PaymentSubmitter paymentSubmitter = new PaymentSubmitter();
    private PaymentValidator paymentValidator = new PaymentValidator();

    public void makePayment(Payment payment) {
        paymentValidator.validate(payment);
        paymentProcessor.process(payment);
        paymentSubmitter.submit(payment);
    }

}
