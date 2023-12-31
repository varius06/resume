package stream_io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultIOUtils implements IOUtils{
    @Override
    public void replaceChars(Reader in, Writer out, String inChars, String outChars) throws NullPointerException, IllegalArgumentException, IOException {
        Objects.requireNonNull(in, "Reader should be not null");
        Objects.requireNonNull(out, "Writer should be not null");
        if(inChars.length() != outChars.length()) {
            throw new IllegalArgumentException("inChars.length != outChars.length: inChars.length=" +
                    inChars.length() + ", outChars.length=" + outChars.length());
        }

        char[] buffer = new char[8192];
        while (true) {
            int read = in.read(buffer);
            if(read == -1) {
                break;
            }
            transformCharArray(buffer, read, inChars, outChars);
            out.write(buffer, 0, read);
        }
        //out.flush();
    }

    @Override
    public List<String> findText(String rootDir, String textToFind, boolean ignoreCase) throws NullPointerException, IllegalArgumentException, IOException {
        File dir = new File(rootDir);
        final List<String> foundPaths = new ArrayList<>();
        dirFind(dir, textToFind, ignoreCase, foundPaths);
        return foundPaths;
    }

    private void dirFind(File dir, String textToFind, boolean ignoreCase, List<String> foundPaths) throws IOException {
        if(dir.isDirectory()) {
            for (File file: dir.listFiles()) {
                if(file.isDirectory()) {
                    dirFind(dir, textToFind, ignoreCase, foundPaths);
                } else {
                    String path = file.getPath();
                    if(fileContainsText1(path, textToFind, ignoreCase)){
                        foundPaths.add(path);
                    }
                }
            }
        }
    }

    protected boolean fileContainsText1(String file, String textToFind, boolean ignoreCase) throws IOException {
        int bufferSize = getBufferSize(textToFind);
        char[] ch1 = new char[bufferSize];
        int offset = 0;
        try (Reader r = new FileReader(file)) {
            while (true) {
                int read = r.read(ch1, offset, bufferSize - offset);
                if (read == -1) {
                    return false;
                }
                String text = new String(ch1, 0, read + offset);
                boolean contains = contains(text, textToFind, ignoreCase);
                if (contains) {
                    return true;
                }
                int half = (read + offset) / 2;

                for (int i = half; i < read + offset; i++) {
                    ch1[i - half] = ch1[i];
                }
                offset = half;
            }
        }
    }

    private boolean contains(String text, String textToFind, boolean ignoreCase) {
        if (ignoreCase) {
            text = text.toLowerCase();
            textToFind = textToFind.toLowerCase();
        }
        return text.contains(textToFind);
    }

    private int getBufferSize(String textToFind) {
        int minBufferSize = 1024 * 1024;
        int bufferSize = textToFind.length() * 4;
        return bufferSize < minBufferSize ? minBufferSize : bufferSize;
    }

    protected boolean fileContainsText2(Path file, String textToFind, boolean ignoreCase) throws IOException {
        String text = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        if (ignoreCase) {
            text = text.toLowerCase();
            textToFind = textToFind.toLowerCase();
        }
        return text.contains(textToFind);
    }

    private void transformCharArray(char[] buffer, int read, String inChars, String outChars) {
        for (int i = 0; i < read; i++) {
            int index = inChars.indexOf(buffer[i]);
            if(index != -1) {
                buffer[i] = outChars.charAt(index);
            }
        }
    }
}
