package pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.sequential;

import lombok.AllArgsConstructor;
import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.ValueFilter;
import pl.mzlnk.javafromzerotohero.concurrency.joins.ex2.parallel.ValueInspectorParallelTask;

@AllArgsConstructor
public class ValueInspectorSequentialTask {

    private static final int THRESHOLD = 500;

    private static int nextTaskId = 0;

    private int taskId;
    private int[] values;
    private int from;
    private int to;
    private ValueFilter filter;
    private int level;

    public ValueInspectorSequentialTask(int[] values, int from, int to, ValueFilter filter, int level) {
        this.taskId = nextTaskId++;
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
        this.level = level;
    }

    public int inspect() {
        this.log("Start task");

        if(this.to - this.from < THRESHOLD) {
            int result = 0;
            for(int i = from; i < to; i++) {
                if(this.filter.filter(this.values[i])) {
                    result++;
                }
            }

            this.log("Finish task");

            return result;
        }

        int midpoint = (from + to) / 2;
        ValueInspectorSequentialTask first = new ValueInspectorSequentialTask(values, from, midpoint, filter, level + 1);
        ValueInspectorSequentialTask second = new ValueInspectorSequentialTask(values, from, midpoint, filter, level + 1);

        int result = first.inspect() + second.inspect();

        this.log("Finish task");

        return result;
    }

    private void log(String msg) {
        String tab = "";
        for(int i = 0; i < level; i++) {
            tab += " ";
        }

        System.out.println(tab + msg + " [" + this.taskId + "][" + Thread.currentThread().getId() + "]");
    }

}
