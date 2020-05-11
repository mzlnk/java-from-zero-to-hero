package behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnnouncementService {

    private List<AnnouncementObserver> observers = new ArrayList<>();

    public AnnouncementService() {

    }

    public void init() {
        new Thread(new AnnouncementTask()).start();
    }

    public void addObserver(AnnouncementObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(AnnouncementObserver observer) {
        this.observers.remove(observer);
    }

    private class AnnouncementTask implements Runnable {

        private ThreadLocalRandom r = ThreadLocalRandom.current();

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("[SERVICE] Sending announcement...");
                    AnnouncementService.this.observers.forEach(ob -> ob.onAnnouncementSent("Some announcement!"));
                    Thread.sleep(r.nextLong(3000) + 1000L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

    }

}
