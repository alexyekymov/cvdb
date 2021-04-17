package com.github.alexyekymov.cvdb.model;

public enum SectionType {
    OBJECTIVE("Position"),
    PERSONAL("Personal skills"),
    ACHIEVEMENT("Achievements"),
    QUALIFICATION("Qualification"),
    EXPERIENCE("Work history"),
    EDUCATION("Education");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
