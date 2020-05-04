package pl.mzlnk.javafromzerotohero.concurrency.joins.ex1;

public class HeroThread extends Thread {

    private String name;

    public HeroThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.println("Thread: " + name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}