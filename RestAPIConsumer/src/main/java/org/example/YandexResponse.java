package org.example;

import java.util.List;

public class YandexResponse {
    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    private List<Translation> translations;
}
