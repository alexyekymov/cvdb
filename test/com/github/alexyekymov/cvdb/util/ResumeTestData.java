package com.github.alexyekymov.cvdb.util;

import com.github.alexyekymov.cvdb.model.*;

import java.time.Month;
import java.util.UUID;

public class ResumeTestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.setContact(ContactType.MAIL, "mail1@google.com");
        R1.setContact(ContactType.PHONE, "12345");

        R4.setContact(ContactType.PHONE, "11111");
        R4.setContact(ContactType.SKYPE, "theBestFileHosting");

        R1.setSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.setSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.setSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        R1.setSection(SectionType.QUALIFICATION, new ListSection("Java", "SQL", "JS"));
        R1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization1", "http://organization1.com",
                                new Organization.Position(2005, Month.JANUARY, "Position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "Position2", "content2")
                        )));
        R1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "http://institute1.gov",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "Student", "Computer science")),
                        new Organization("College", "http://college1.gov")));
        R2.setContact(ContactType.SKYPE, "skype1");
        R2.setContact(ContactType.PHONE, "54321");
        R2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://organization2.com",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
    }
}
