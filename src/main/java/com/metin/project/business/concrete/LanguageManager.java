package com.metin.project.business.concrete;

import com.metin.project.business.abstracts.LanguageService;
import com.metin.project.business.requests.CreateLanguageRequest;
import com.metin.project.business.requests.UpdateLanguageRequest;
import com.metin.project.business.responses.GetAllLanguagesResponse;
import com.metin.project.business.responses.GetByIdLanguageResponse;
import com.metin.project.core.utilites.mappers.ModelMapperService;
import com.metin.project.dataAccess.abstracts.LanguageRepository;
import com.metin.project.entities.concrete.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses = languages.stream().map(language -> this.modelMapperService.forResponse().map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
        return languagesResponses;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = languageRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
        List<Language> languages = this.languageRepository.findAll();

        if (createLanguageRequest.getName() == "") throw new Exception("İsim boş olamaz.");

        for (Language l : languages) {
            if (l.getName().equals(language.getName())) throw new Exception("İsim sistemde kayıtlı.");
        }

        this.languageRepository.save(language);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        languageRepository.findById(updateLanguageRequest.getId()).orElseThrow();

        Language language = this.modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        this.languageRepository.deleteById(id);
    }
}
