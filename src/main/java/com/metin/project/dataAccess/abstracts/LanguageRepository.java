package com.metin.project.dataAccess.abstracts;

import com.metin.project.entities.concrete.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
