package com.metin.project.business.abstracts;

import com.metin.project.business.requests.CreateLanguageRequest;
import com.metin.project.business.requests.UpdateLanguageRequest;
import com.metin.project.business.responses.GetAllLanguagesResponse;
import com.metin.project.business.responses.GetByIdLanguageResponse;
import com.metin.project.entities.concrete.Language;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();

    GetByIdLanguageResponse getById(int id);

    void add(CreateLanguageRequest createLanguageRequest) throws Exception;

    void update(UpdateLanguageRequest updateLanguageRequest);

    void delete(int id);
}
