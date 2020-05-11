package behavioral.observer;

public class Dashboard implements AnnouncementObserver {

    private String name;

    public Dashboard(String name) {
        this.name = name;
    }

    @Override
    public void onAnnouncementSent(String announcement) {
        System.out.println("[" + this.name + "] " + announcement);
    }

}
