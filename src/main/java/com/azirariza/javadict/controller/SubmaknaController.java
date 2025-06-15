package com.azirariza.javadict.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azirariza.javadict.entity.Submakna;
import com.azirariza.javadict.entity.dto.SubmaknaDTOInsert;
import com.azirariza.javadict.entity.dto.SubmaknaDTOUpdate;
import com.azirariza.javadict.service.SubmaknaService;

@RestController
@RequestMapping({ "/api/submakna", "api/submakna/" })
public class SubmaknaController {
    private final SubmaknaService submaknaService;

    public SubmaknaController(SubmaknaService submaknaService) {
        this.submaknaService = submaknaService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<Submakna>> getAllSubmakna() {
        return ResponseEntity.ok(submaknaService.getAllSubmakna());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submakna> getSubmaknaById(@PathVariable int id) {
        Optional<Submakna> entri = submaknaService.getSubmaknaById(id);
        return entri.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Submakna> createSubmakna(@RequestBody SubmaknaDTOInsert submaknaDTO) {
        Submakna createdKata = submaknaService.createSubmakna(submaknaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submakna> updateSubmakna(@PathVariable int id,
            @RequestBody SubmaknaDTOUpdate submaknaDTO) {
        return ResponseEntity.ok(submaknaService.updateSubmakna(id, submaknaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmakna(@PathVariable int id) {
        submaknaService.deleteSubmakna(id);
        return ResponseEntity.noContent().build();
    }
}
