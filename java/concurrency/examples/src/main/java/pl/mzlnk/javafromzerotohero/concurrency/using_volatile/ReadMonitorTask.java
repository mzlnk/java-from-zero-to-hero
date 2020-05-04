package pl.mzlnk.javafromzerotohero.concurrency.using_volatile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReadMonitorTask implements Runnable {

    private TemperatureMonitor monitor;

    @Override
    public void run() {
        int currentTemp = monitor.getTemperature();
        while (true) {
            if(currentTemp != monitor.getTemperature()) {
                System.out.println("Temperature changed");
                currentTemp = monitor.getTemperature();
            }
        }
    }

}
