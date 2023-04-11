package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer>{
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
    @Override
    protected void doSave(Resume resume, Integer index) {
        list.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Integer index) {
        list.set(index, resume);
    }

    @Override
    protected Resume doGet(Integer uuid) {
        return list.get(uuid);
    }


    @Override
    protected void doDelete(Integer object) {
        if(object != null) {
            list.remove(object.intValue());
        }
    }

    @Override
    protected boolean isExist(Integer searchKey) {
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
