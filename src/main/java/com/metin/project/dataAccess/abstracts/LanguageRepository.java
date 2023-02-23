package com.metin.project.dataAccess.abstracts;

import com.metin.project.entities.concrete.Language;

import java.util.List;

public interface LanguageRepository {
    void add(Language language);

    void delete(int id);

    List<Language> getAll();

    Language getLanguage(int id);
}
