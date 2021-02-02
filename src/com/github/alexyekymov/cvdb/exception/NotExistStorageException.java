package com.github.alexyekymov.cvdb.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " doesn't not exist", uuid);
    }
}
