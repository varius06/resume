import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import storage.AbstractStorage;
import storage.SortedArrayStorage;

import java.io.*;
import java.util.*;

public class MainTestArrayStorage {
    static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());
    static final AbstractStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) throws NotExistStorageException{
        String answer = "yes";
        Scanner sc = new Scanner(System.in);
        Resume r1 = new Resume("uuid1", "Name1");
        Resume r2 = new Resume("uuid2", "Name2");
        Resume r3 = new Resume("uuid3", "Name2");
        System.out.println(r1.getUuid().equals(r2.getUuid()));

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        //ARRAY_STORAGE.save(r3);
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch (RuntimeException ex) {
            System.out.println("My exception: " + ex.getMessage());
        }



        printAll();

        System.out.println("До Сортировки");
        List<Resume> list = new ArrayList<>();
        list.add(r2);
        list.add(r1);
        list.add(r3);
        for (Resume str : list) {
            System.out.println(str.getUuid());
        }
        System.out.println("После Сортировки");
        list.sort(RESUME_COMPARATOR);
        for (Resume str : list) {
            System.out.println(str.getUuid());
        }



        /*StringBuilder sb = new StringBuilder();
        String str = "main";
        String path = "C:\\java\\resume\\storage\\simple.txt";
        try(OutputStream outputStream = new FileOutputStream(path);) {
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[4];
        int byteCount = -1;
        try(InputStream inputStream = new FileInputStream(path);) {
            while (inputStream.read(bytes) != -1) {
                for (int i = 0;  bytes.length > i; i++) {
                    int code = bytes[i];
                    System.out.println(code + "    " + (char)code);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        char ascii = (char) 97;
        System.out.println(ascii);
        char first1 = '\u002F';
        System.out.println(first1);
*/

        /*try (Reader reader = new InputStreamReader(new FileInputStream(path), "UTF-8")) {
            int data = reader.read();
            while (data != -1) {
                sb.append((char) data);
                data = reader.read();
            }
            System.out.println("Чтение Файла: " + sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileWriter writer = new FileWriter(path)) {
            //writer.write("test");
            String pp = "test2";
            writer.write(pp);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //ARRAY_STORAGE.delete(r2.getUuid());
        //printAll();
        //ARRAY_STORAGE.clear();
        //printAll();

        //System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Object r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}