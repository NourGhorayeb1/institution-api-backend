package com.example.institution_api.controller;

import com.example.institution_api.model.Institution;
import com.example.institution_api.service.InstitutionService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/institutions")
@CrossOrigin
public class InstitutionController {

    private final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Institution> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institution> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public List<Institution> getActive() {
        return service.getActiveInstitutions();
    }

    @PostMapping
    public ResponseEntity<Institution> createOrUpdate(@Validated @RequestBody Institution institution) {
        Institution saved = service.createOrUpdate(institution);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id); // throws if not found
        return ResponseEntity.noContent().build();
    }
}
