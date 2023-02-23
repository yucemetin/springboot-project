package com.metin.project.dataAccess.concrete;

import com.metin.project.dataAccess.abstracts.LanguageRepository;
import com.metin.project.entities.concrete.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "JavaScript"));
        languages.add(new Language(3, "C#"));
        languages.add(new Language(4, "Go"));
        languages.add(new Language(5, "Kotlin"));
    }

    @Override
    public void add(Language language) {
        if (!languages.contains(language) && language.getName() != "") languages.add(language);
    }

    @Override
    public void delete(int id) {
        languages.remove(id);
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getLanguage(int id) {
        for (Language language : languages) {
            if (language.getId() == id) return language;
        }

        return null;
    }
}
