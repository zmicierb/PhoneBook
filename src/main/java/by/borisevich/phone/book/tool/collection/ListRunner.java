package by.borisevich.phone.book.tool.collection;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dima on 10/4/16.
 */
public class ListRunner implements Callable<Long> {

    private int start;
    private int end;
    private List<Integer> list;
    private CountDownLatch latch;

    public ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
        this.start = start;
        this.end = end;
        this.list = list;
        this.latch = latch;
    }

    public Long call() throws Exception {
        latch.await();

        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            list.get(i);
            if (i % 10 == 0)
                list.add(i);
        }
        return System.nanoTime() - startTime;
    }
}
