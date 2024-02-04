package kotlin_lambuda;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class DownloadVideo {

    public static void main(String[] strings) {
        System.out.println("start at " + new Date());
        String url = "https://download.samplelib.com/mp4/sample-5s.mp4";
        int count = 0;

        try(InputStream inputStream = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("video2.mp4")) {
            byte[] buffer = new byte[1024];

            while (true) {
                int byteRead = inputStream.read(buffer, 0, 1024);
                if(byteRead == -1) {
                    break;
                }
                fileOutputStream.write(buffer, 0, byteRead);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("count " + count);
            System.out.println("finished at " + new Date());
        }

    }
}
