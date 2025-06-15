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

import com.azirariza.javadict.entity.Contoh;
import com.azirariza.javadict.entity.dto.ContohDTOInsert;
import com.azirariza.javadict.entity.dto.ContohDTOUpdate;
import com.azirariza.javadict.service.ContohService;

@RestController
@RequestMapping({ "/api/contoh", "api/contoh/" })
public class ContohController {
    private final ContohService contohService;

    public ContohController(ContohService contohService) {
        this.contohService = contohService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<Contoh>> getAllContoh() {
        return ResponseEntity.ok(contohService.getAllContoh());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contoh> getContohById(@PathVariable int id) {
        Optional<Contoh> entri = contohService.getContohById(id);
        return entri.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contoh> createContoh(@RequestBody ContohDTOInsert contohDTO) {
        Contoh createdKata = contohService.createContoh(contohDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contoh> updateContoh(@PathVariable int id,
            @RequestBody ContohDTOUpdate contohDTO) {
        return ResponseEntity.ok(contohService.updateContoh(id, contohDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContoh(@PathVariable int id) {
        contohService.deleteContoh(id);
        return ResponseEntity.noContent().build();
    }
}
