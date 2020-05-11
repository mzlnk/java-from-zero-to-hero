package structural.facade;

import structural.facade.payment.Payment;
import structural.facade.payment.PaymentFacade;

public class FacadeTest {

    public static void main(String[] args) {
        Payment payment = new Payment(890.20D);

        PaymentFacade paymentFacade = new PaymentFacade();
        paymentFacade.makePayment(payment);
    }

}
