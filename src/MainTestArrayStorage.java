import exception.NotExistStorageException;
import model.Resume;
import storage.AbstractStorage;
import storage.SortedArrayStorage;

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
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));


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

        //ARRAY_STORAGE.delete(r2.getUuid());
        //printAll();
        //ARRAY_STORAGE.clear();
        //printAll();

        //System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}