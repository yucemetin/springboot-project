package com.metin.project.webApi.controllers;

import com.metin.project.business.abstracts.SubTechnologyService;
import com.metin.project.business.requests.CreateSubTechnologyRequest;
import com.metin.project.business.requests.UpdateSubTechnologyRequest;
import com.metin.project.business.responses.GetAllSubTechnologiesResponse;
import com.metin.project.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/technologies")
public class SubTechnologyController {
    private SubTechnologyService subTechnologyService;

    @GetMapping("/getAll")
    List<GetAllSubTechnologiesResponse> getAll() {
        return this.subTechnologyService.getAll();
    }

    @GetMapping("/{id}")
    GetByIdTechnologyResponse getById(@PathVariable int id) {
        return this.subTechnologyService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
        this.subTechnologyService.add(createSubTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        this.subTechnologyService.update(updateSubTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.subTechnologyService.delete(id);
    }
}
