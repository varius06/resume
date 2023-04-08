package storage;

import arraylist.Simple;
import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage{

    protected abstract Object getSearchKey(String uuid);
    protected abstract void doSave(Resume resume, Object index);
    protected abstract void doDelete(Object resume);
    protected abstract boolean isExist(Object searchKey);
    protected abstract void doUpdate(Resume resume, Object index);
    protected abstract Resume doGet(Object uuid);
    protected abstract List<Resume> doCopyAll();
    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }
    public void update(Resume resume) {
        Object index = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, index);
    }

    public Resume get(String uuid) {
        Object object = getExistedSearchKey(uuid);
        return doGet(object);
    }
    public void delete(String uuid) {
        Object index = getExistedSearchKey(uuid);
        doDelete(index);
    }
    private Object getNotExistedSearchKey(String uuid) {
        Object object = getSearchKey(uuid);
        if (isExist(object)) {
            throw new ExistStorageException(uuid);
        }
        return object;
    }
    private Object getExistedSearchKey(String uuid) {
        Object object = getSearchKey(uuid);
        if (!isExist(object)) {
            throw new NotExistStorageException(uuid);
        }
        return object;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }


}
