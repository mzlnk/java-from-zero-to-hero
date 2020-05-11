import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    public static void main(String[] args) {
        final AnnouncementService service = new AnnouncementService();

        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("DASH-1"));
        dashboards.add(new Dashboard("DASH-2"));
        dashboards.add(new Dashboard("DASH-3"));

        dashboards.forEach(service::addObserver);

        service.init();
    }

}
