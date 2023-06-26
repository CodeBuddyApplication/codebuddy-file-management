package com.codebuddy.task.enums;

public enum CodeLanguage {
    JAVA("java"),
    NONE("none");

    private final String language;

    CodeLanguage(String language) {
        this.language = language;
    }

    public String getLanguageValue() {
        return this.language;
    }
}