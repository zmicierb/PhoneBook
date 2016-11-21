package by.borisevich.phone.book.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/**
 * Created by dima on 11/21/16.
 */
public class Downloader implements Callable<Void> {

    private String url;
    private String downloadPath;

    public Downloader(String url, String downloadPath) {
        this.url = url;
        this.downloadPath = downloadPath;
    }

    @Override
    public Void call() throws Exception {
        String targetPath;
        URL link = new URL(url);
        String fileName = link.getFile().substring(link.getFile().lastIndexOf('/'), link.getFile().length());
        if (new File(downloadPath).isDirectory()) {
            targetPath = downloadPath + fileName;
            try (ReadableByteChannel rbc = Channels.newChannel(link.openStream());
                 FileOutputStream fos = new FileOutputStream(targetPath)) {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            } catch (FileNotFoundException e) {
                throw new IOException("Can`t create file.", e);
            } catch (IOException e) {
                throw new IOException("Wrong url for downloading.", e);
            }
        } else {
            throw new IOException("Download directory does not exist");
        }

        return null;
    }
}
