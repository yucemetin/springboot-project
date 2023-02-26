package com.metin.project.business.concrete;

import com.metin.project.business.abstracts.SubTechnologyService;
import com.metin.project.business.requests.CreateSubTechnologyRequest;
import com.metin.project.business.requests.UpdateSubTechnologyRequest;
import com.metin.project.business.responses.GetAllSubTechnologiesResponse;
import com.metin.project.business.responses.GetByIdTechnologyResponse;
import com.metin.project.core.utilites.mappers.ModelMapperService;
import com.metin.project.dataAccess.abstracts.SubTechnologyRepository;
import com.metin.project.entities.concrete.SubTechnology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {

    private SubTechnologyRepository subTechnologyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllSubTechnologiesResponse> getAll() {
        List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
        List<GetAllSubTechnologiesResponse> subTechnologiesResponse = subTechnologies.stream().map(subTechnology -> this.modelMapperService.forResponse().map(subTechnology, GetAllSubTechnologiesResponse.class)).collect(Collectors.toList());
        return subTechnologiesResponse;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        SubTechnology subTechnology = subTechnologyRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(subTechnology, GetByIdTechnologyResponse.class);
    }

    @Override
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
        SubTechnology subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest, SubTechnology.class);

        this.subTechnologyRepository.save(subTechnology);
    }

    @Override
    public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        SubTechnology subTechnology = this.modelMapperService.forRequest().map(updateSubTechnologyRequest, SubTechnology.class);
        this.subTechnologyRepository.save(subTechnology);
    }

    @Override
    public void delete(int id) {
        this.subTechnologyRepository.deleteById(id);
    }
}
