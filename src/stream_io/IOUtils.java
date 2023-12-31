package stream_io;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public interface IOUtils {
    void replaceChars(Reader in, Writer out, String inChars, String outChars) throws NullPointerException, IllegalArgumentException, IOException;

    List<String> findText(String rootDir, String textToFind, boolean ignoreCase) throws NullPointerException, IllegalArgumentException, IOException;
}
