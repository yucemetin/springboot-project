package com.metin.project.business.abstracts;

import com.metin.project.business.requests.CreateSubTechnologyRequest;
import com.metin.project.business.requests.UpdateSubTechnologyRequest;
import com.metin.project.business.responses.GetAllSubTechnologiesResponse;
import com.metin.project.business.responses.GetByIdTechnologyResponse;

import java.util.List;

public interface SubTechnologyService {
    List<GetAllSubTechnologiesResponse> getAll();

    GetByIdTechnologyResponse getById(int id);

    void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;

    void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);

    void delete(int id);
}
