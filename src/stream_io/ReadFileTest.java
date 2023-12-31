package stream_io;

import java.io.*;

public class ReadFileTest {
    public static void main(String[] args) throws IOException {
        readChar();
    }

    public static void readChar() throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] buf = new char[8192];
        Reader reader = new FileReader("test.txt");
        while (true) {
            int read = reader.read(buf);
            if(read == -1) {
                break;
            }
            stringWriter.write(buf, 0, read);
        }
        reader.close();
        System.out.println(stringWriter);
    }

    public static void readWriteStream() throws IOException, IllegalArgumentException{
        InputStream inputStream = new FileInputStream("text-file.txt");
        OutputStream outputStream = new FileOutputStream("text-file-copy.txt");
        byte[] bytes = new byte[1];
        while (true) {
            int read = inputStream.read(bytes);
            if(read == -1) {
                break;
            }
            outputStream.write(bytes, 0, read);
        }


    }


}
