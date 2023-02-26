package com.metin.project.dataAccess.abstracts;

import com.metin.project.entities.concrete.SubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {
}
