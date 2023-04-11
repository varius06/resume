package storage;

import arraylist.Simple;
import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage{

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    protected abstract SK getSearchKey(String uuid);
    protected abstract void doSave(Resume resume, SK index);
    protected abstract void doDelete(SK resume);
    protected abstract boolean isExist(SK searchKey);
    protected abstract void doUpdate(Resume resume, SK index);
    protected abstract Resume doGet(SK uuid);
    protected abstract List<Resume> doCopyAll();
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK index = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, index);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK object = getExistedSearchKey(uuid);
        return doGet(object);
    }
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK index = getExistedSearchKey(uuid);
        doDelete(index);
    }
    private SK getNotExistedSearchKey(String uuid) {
        SK object = getSearchKey(uuid);
        if (isExist(object)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return object;
    }
    private SK getExistedSearchKey(String uuid) {
        SK object = getSearchKey(uuid);
        if (!isExist(object)) {
            LOG.warning("Resume " + uuid + " not exist");
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
