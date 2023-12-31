package stream_io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.List;

public class DefaultIOUtilsTest {
    public static void main(String[] args) throws IOException {
        IOUtils ioUtils = new DefaultIOUtils();

        StringReader in = new StringReader("1234567890");
        String inChars = "357";
        String outChars = "480";
        StringWriter out = new StringWriter();
        try {
            ioUtils.replaceChars(in, out, inChars, outChars);
            System.out.println(out);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        List<String> foundPaths = ioUtils.findText("text", "purposes", true);
        if(foundPaths.isEmpty()) {
            System.out.println("Files not found");
        } else {
            for (String path: foundPaths) {
                System.out.println(path);
            }
        }
    }
}
