package by.borisevich.phone.book.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dima on 11/21/16.
 */
public class ConsoleHTTPDownloader {

    public static final int THREAD_COUNT = 3;

    private ConsoleHTTPDownloader() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(THREAD_COUNT);

        ex.submit(new Downloader("http://risovach.ru/upload/2013/05/mem/telik_19995463_orig_.jpeg", "DownloadTest"));

    }

}
