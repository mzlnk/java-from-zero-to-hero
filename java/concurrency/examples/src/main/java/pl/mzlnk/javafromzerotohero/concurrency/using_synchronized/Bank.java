package pl.mzlnk.javafromzerotohero.concurrency.using_synchronized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.DoubleStream;

public class Bank {

    private final String TRANSFER_MSG = "Transferred ? from ? to ?. ";

    private final double[] accounts;

    public Bank(int accounts, double initValue) {
        this.accounts = new double[accounts];

        for (int i = 0; i < accounts; i++) {
            this.accounts[i] = initValue;
        }
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while(accounts[from] < amount) {
            wait();
        }

        System.out.print(Thread.currentThread());

        accounts[from] -= amount;
        accounts[to] += amount;

        System.out.print(TRANSFER_MSG
                .replaceFirst("\\?", String.valueOf(amount))
                .replaceFirst("\\?", String.valueOf(from))
                .replaceFirst("\\?", String.valueOf(to)));


        System.out.println("Total bank balance: " + this.getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        return DoubleStream.of(accounts).sum();
    }

    public int size() {
        return this.accounts.length;
    }

}
