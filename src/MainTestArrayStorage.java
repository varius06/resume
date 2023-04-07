import exception.NotExistStorageException;
import model.Resume;
import storage.AbstractArrayStorage;
import storage.AbstractStorage;
import storage.ListStorage;
import storage.SortedArrayStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTestArrayStorage {
    static final AbstractStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) throws NotExistStorageException{
        String answer = "yes";
        Scanner sc = new Scanner(System.in);
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        System.out.println(r1.getUuid().equals(r2.getUuid()));

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));


        printAll();



        List<Resume> list = new ArrayList<>();

        //ARRAY_STORAGE.delete(r2.getUuid());
        //printAll();
        //ARRAY_STORAGE.clear();
        //printAll();

        //System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}