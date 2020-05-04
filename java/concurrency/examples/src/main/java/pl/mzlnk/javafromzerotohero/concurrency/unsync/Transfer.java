package pl.mzlnk.javafromzerotohero.concurrency.unsync;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Transfer implements Runnable {

    private Bank bank;
    private int from;

    @Override
    public void run() {
        try {

            while (true) {
                int to = (int) (bank.size() * Math.random());
                double amount = 1000 * Math.random();

                this.bank.transfer(this.from, to, amount);

                Thread.sleep((long) (10 * Math.random()));
            }

        } catch (InterruptedException e) {
        }
    }

}
