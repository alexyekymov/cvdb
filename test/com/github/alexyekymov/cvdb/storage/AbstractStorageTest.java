package com.github.alexyekymov.cvdb.storage;

import com.github.alexyekymov.cvdb.exception.ExistStorageException;
import com.github.alexyekymov.cvdb.exception.NotExistStorageException;
import com.github.alexyekymov.cvdb.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@google.com");
        R1.addContact(ContactType.PHONE, "12345");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        R1.addSection(SectionType.QUALIFICATION, new ListSection("Java", "SQL", "JS"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization1", "http://organization1.com",
                                new Organization.Position(2005, Month.JANUARY, "Position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "Position2", "content2")
                        )));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "http://institute1.gov",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "Student", "Computer science")),
                        new Organization("College", "http://college1.gov")));
        R2.addContact(ContactType.SKYPE, "skype1");
        R2.addContact(ContactType.PHONE, "54321");
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://organization2.com",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "New Name");
        storage.update(newResume);
        assertEquals(storage.get(UUID_1), newResume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("dummy"));// mb get()???
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(Arrays.asList(R1, R2, R3), list);
    }

    @Test
    public void save() {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(R1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.delete(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void get() {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int i) {
        assertEquals(i, storage.size());
    }
}
