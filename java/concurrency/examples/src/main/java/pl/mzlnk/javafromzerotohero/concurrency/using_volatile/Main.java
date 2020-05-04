package pl.mzlnk.javafromzerotohero.concurrency.using_volatile;

public class Main {

    public static void main(String[] args) {
        final TemperatureMonitor monitor = new TemperatureMonitor();

        Runnable readTask = new ReadMonitorTask(monitor);
        Runnable updateTask = new UpdateMonitorTask(monitor);

        Thread readThread = new Thread(readTask);
        Thread updateThread = new Thread(updateTask);

        readThread.start();
        updateThread.start();

    }

}
