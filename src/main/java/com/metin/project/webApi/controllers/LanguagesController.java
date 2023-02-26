package com.metin.project.webApi.controllers;

import com.metin.project.business.abstracts.LanguageService;
import com.metin.project.business.requests.CreateLanguageRequest;
import com.metin.project.business.requests.UpdateLanguageRequest;
import com.metin.project.business.responses.GetAllLanguagesResponse;
import com.metin.project.business.responses.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
    private LanguageService languageService;

    @GetMapping("/getAll")
    List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    GetByIdLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        this.languageService.add(createLanguageRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
        this.languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.languageService.delete(id);
    }
}

