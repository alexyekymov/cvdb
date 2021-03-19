package com.github.alexyekymov.cvdb.storage;

import com.github.alexyekymov.cvdb.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}