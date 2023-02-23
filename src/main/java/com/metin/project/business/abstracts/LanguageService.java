package com.metin.project.business.abstracts;

import com.metin.project.entities.concrete.Language;

import java.util.List;

public interface LanguageService {
    void add(Language language);

    void delete(int id);

    List<Language> getAll();

    Language getLanguage(int id);
}
