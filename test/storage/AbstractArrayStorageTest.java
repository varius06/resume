package storage;

import exception.NotExistStorageException;
import model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);
    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
    }

    @Test
    public void update() {
        Resume resume = new Resume("uuid3");
    }

    @Test
    public void getAll() {
        storage.getAll();
    }

    @Test
    public void save() {
        Resume resume = new Resume("uuid4");
        storage.save(resume);
    }

    @Test
    public void delete() {
        storage.delete("uuid3");
    }

    @Test
    public void get() {
        Resume resume = new Resume("uuid3");
        assertEquals(resume, storage.get("uuid3"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }
}