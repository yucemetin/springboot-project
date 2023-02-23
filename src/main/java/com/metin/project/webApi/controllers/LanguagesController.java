package com.metin.project.webApi.controllers;

import com.metin.project.business.abstracts.LanguageService;
import com.metin.project.entities.concrete.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    Language add(@RequestBody Language language) {
        languageService.add(language);
        return language;
    }

    @GetMapping("/{id}")
    Language getLanguage(@PathVariable int id) {
        return languageService.getLanguage(id);
    }

    @PutMapping("/delete/{id}")
    Language delete(@PathVariable int id) {
        languageService.delete(id);
        return languageService.getLanguage(id);
    }
}

