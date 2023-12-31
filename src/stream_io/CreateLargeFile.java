package stream_io;

import java.io.*;

public class CreateLargeFile {
    public static void main(String[] args) throws IOException {
        String s = "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.";
        try(Writer wr = new BufferedWriter(new FileWriter("test/large.txt"))){
            for(int i=0;i<20000000;i++){
                wr.write(s+"\r\n");
                if(i==100000) {
                    wr.write("purposes"+"\r\n");
                }
            }
            wr.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("File created: "+new File("test/large.txt").length()+" bytes");
    }
}
