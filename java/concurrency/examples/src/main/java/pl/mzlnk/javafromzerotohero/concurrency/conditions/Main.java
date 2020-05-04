package pl.mzlnk.javafromzerotohero.concurrency.conditions;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(100, 1000D);

        for(int i = 0; i < 100; i++) {
            Transfer transfer = new Transfer(bank, i);
            Thread t = new Thread(transfer);
            t.start();
        }

    }

}
