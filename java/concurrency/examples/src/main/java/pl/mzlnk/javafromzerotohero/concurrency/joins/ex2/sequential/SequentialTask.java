package pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.sequential;

import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.Task;

import java.util.Random;
import java.util.stream.IntStream;

public class SequentialTask implements Task {

    @Override
    public void execute() {
        final int SIZE = 1_000_000;
        final Random r = new Random();

        int[] values = IntStream
                .generate(() -> r.nextInt(5000))
                .limit(SIZE)
                .toArray();

        ValueInspectorSequentialTask task = new ValueInspectorSequentialTask(values, 0, SIZE, i -> i % 3 == 0, 0);

        int result = task.inspect();
        System.out.println("Result: " + result);
    }

}
