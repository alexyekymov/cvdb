package com.github.alexyekymov.cvdb.util;

import com.github.alexyekymov.cvdb.model.*;
import com.github.alexyekymov.cvdb.storage.Storage;

import java.time.Month;

public class ResumeTestData {
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";
    public static final String UUID_4 = "uuid4";

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

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

    public static void refill(Storage storage) {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }
}
