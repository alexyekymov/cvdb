package com.github.alexyekymov.cvdb.storage;

import com.github.alexyekymov.cvdb.exception.StorageException;
import com.github.alexyekymov.cvdb.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            fail();
        }
        storage.save(new Resume("Overflow"));
    }
}