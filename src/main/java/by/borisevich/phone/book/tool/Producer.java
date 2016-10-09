package by.borisevich.phone.book.tool;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by dima on 10/5/16.
 */
public class Producer implements Runnable {

    private static final int CNT = 3;
    private static final int random_work_time = 3000;

    private SynchronousQueue<Integer> queue;

    public Producer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < CNT; i++) {

            try {
                Thread.sleep(random_work_time);
                System.out.println("Producer: inserting...");
                queue.put(i);
                System.out.println("Producer: next turn.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
