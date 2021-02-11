package com.github.alexyekymov.cvdb.storage;

import com.github.alexyekymov.cvdb.exception.StorageException;
import com.github.alexyekymov.cvdb.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void doUpdate(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public void doSave(Resume resume, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow ", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    @Override
    public void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    public Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract Integer getSearchKey(String uuid);
}
