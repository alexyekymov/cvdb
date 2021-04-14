package com.github.alexyekymov.cvdb.model;

public enum ContactType {
    PHONE("Phone number"),
    MOBILE("Mobile number"),
    HOME_PHONE("Home number"),
    SKYPE("Skype") {
        @Override
        protected String toHtml0(String value) {
            return getTitle() + ": " + toLink("skype:" + value, value);
        }
    },
    MAIL("E-mail") {
        @Override
        protected String toHtml0(String value) {
            return getTitle() + ": " + toLink("mailto:" + value, value);
        }
    },
    LINKEDIN("Linkedin profile") {
        @Override
        public String toLink(String href) {
            return toLink(href);
        }
    },
    GITHUB("Github profile") {
        @Override
        public String toLink(String href) {
            return toLink(href);
        }
    },
    STACKOVERFLOW("Stackoverflow profile") {
        @Override
        public String toLink(String href) {
            return toLink(href);
        }
    },
    HOME_PAGE("Home page") {
        @Override
        public String toLink(String href) {
            return toLink(href);
        }
    };

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected String toHtml0(String value) {
        return title + ": " + value;
    }

    public String toHtml(String value) {
        return (value == null) ? "" : toHtml0(value);
    }

    public String toLink(String href) {
        return toLink(href, title);
    }

    public String toLink(String href, String title) {
        return "<a href='" + href + "'>" + title + "</a>";
    }
}
