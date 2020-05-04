package pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.parallel;

import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.Task;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelTask implements Task {

    @Override
    public void execute() {
        final int SIZE = 1_000_000;
        final Random r = new Random();

        int[] values = IntStream
                .generate(() -> r.nextInt(5000))
                .limit(SIZE)
                .toArray();

        ValueInspectorParallelTask task = new ValueInspectorParallelTask(values, 0, SIZE, i -> i % 3 == 0, 0);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        int result = task.join();
        System.out.println("Result: " + result);
    }

}
