package pl.mzlnk.javafromzerotohero.concurrency.using_volatile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateMonitorTask implements Runnable {

    private TemperatureMonitor monitor;

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("Set new temperature");
                monitor.incrementTemperature();

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {

        }
    }


}
