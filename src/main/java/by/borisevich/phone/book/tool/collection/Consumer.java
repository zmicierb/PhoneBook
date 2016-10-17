package by.borisevich.phone.book.tool.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by dima on 10/5/16.
 */
public class Consumer implements Runnable {

    private static final int CNT = 3;
    private static final int random_work_time = 1000;

    private SynchronousQueue<Integer> queue;

    public Consumer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < CNT; i++) {
            try {
                System.out.println("Consumer: waiting...");
                int result = queue.take();
                System.out.println("Consumer: get result.");
                Thread.sleep(random_work_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
