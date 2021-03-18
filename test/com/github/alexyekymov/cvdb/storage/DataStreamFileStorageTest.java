package com.github.alexyekymov.cvdb.storage;

import com.github.alexyekymov.cvdb.storage.serializer.DataStreamSerializer;

public class DataStreamFileStorageTest extends AbstractStorageTest {
    public DataStreamFileStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}
