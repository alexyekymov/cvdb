package com.github.alexyekymov.cvdb.model;

public enum ContactType {
    PHONE("Phone number"),
    MOBILE("Mobile number"),
    HOME_PHONE("Home number"),
    SKYPE("Skype"),
    MAIL("E-mail"),
    LINKEDIN("Linkedin profile"),
    GITHUB("Github profile"),
    STACKOVERFLOW("Stackoverflow profile"),
    HOME_PAGE("Home page");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
