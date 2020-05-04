package pl.mzlnk.javafromzerotohero.concurrency.joins.ex1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        threads[0] = new HeroThread("Hero 1");
        threads[1] = new HeroThread("Hero 2");
        threads[2] = new HeroThread("Hero 3");

        for(int i = 0; i < 3; i++) {
            threads[i].start();
            threads[i].join();
        }
    }

}
