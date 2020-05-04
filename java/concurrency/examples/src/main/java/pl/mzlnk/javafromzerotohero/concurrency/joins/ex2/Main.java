package pl.mzlnk.javafromzerotohero.concurrency.joins.ex2;

import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.parallel.ParallelTask;
import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.sequential.SequentialTask;

public class Main {

    public static void main(String[] args) {
        Task parallelTask = new ParallelTask();
        Task sequentialTask = new SequentialTask();

        parallelTask.execute();
        sequentialTask.execute();
    }

}
