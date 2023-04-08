package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
    @Override
    protected void doSave(Resume resume, Object index) {
        list.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        list.set((Integer)index, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return list.get((Integer) uuid);
    }


    @Override
    protected void doDelete(Object object) {
        if(object != null) {
            list.remove(((Integer) object).intValue());
        }
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
    @Override
    public void clear() {
        list.clear();
    }
    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }
    @Override
    public int size() {
        return list.size();
    }

}
