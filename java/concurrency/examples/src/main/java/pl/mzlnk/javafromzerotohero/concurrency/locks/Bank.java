package pl.mzlnk.javafromzerotohero.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.DoubleStream;

public class Bank {

    private final String TRANSFER_MSG = "Transferred ? from ? to ?. ";

    private final double[] accounts;
    private Lock transferLock = new ReentrantLock();

    public Bank(int accounts, double initValue) {
        this.accounts = new double[accounts];

        for (int i = 0; i < accounts; i++) {
            this.accounts[i] = initValue;
        }
    }

    public void transfer(int from, int to, double amount) {
        transferLock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= amount;
            accounts[to] += amount;

            System.out.print(TRANSFER_MSG
                    .replaceFirst("\\?", String.valueOf(amount))
                    .replaceFirst("\\?", String.valueOf(from))
                    .replaceFirst("\\?", String.valueOf(to)));


            System.out.println("Total bank balance: " + this.getTotalBalance());

        } finally {
            transferLock.unlock();
        }

    }

    public double getTotalBalance() {
        return DoubleStream.of(accounts).sum();
    }

    public int size() {
        return this.accounts.length;
    }

}
