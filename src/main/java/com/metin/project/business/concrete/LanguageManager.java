package com.metin.project.business.concrete;

import com.metin.project.business.abstracts.LanguageService;
import com.metin.project.dataAccess.abstracts.LanguageRepository;
import com.metin.project.entities.concrete.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(Language language) {
        languageRepository.add(language);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getLanguage(int id) {
        return languageRepository.getLanguage(id);
    }
}
