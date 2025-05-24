package com.example.institution_api.repository;

import com.example.institution_api.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    List<Institution> findByStatus(Integer status);
}
