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

import com.azirariza.javadict.entity.Entri;
import com.azirariza.javadict.entity.dto.EntriDTOInsert;
import com.azirariza.javadict.entity.dto.EntriDTOUpdate;
import com.azirariza.javadict.service.EntriService;

@RestController
@RequestMapping({ "/api/entri", "api/entri/" })
public class EntriController {
    private final EntriService entriService;

    public EntriController(EntriService entriService) {
        this.entriService = entriService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<Entri>> getAllEntri() {
        return ResponseEntity.ok(entriService.getAllEntri());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entri> getEntriById(@PathVariable String id) {
        Optional<Entri> entri = entriService.getEntriById(id);
        return entri.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entri> createEntri(@RequestBody EntriDTOInsert entriDTO) {
        Entri createdKata = entriService.createEntri(entriDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entri> updateEntri(@PathVariable int idEntri, @RequestBody EntriDTOUpdate entriDTO) {
        return ResponseEntity.ok(entriService.updateEntri(idEntri, entriDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntri(@PathVariable int idEntri) {
        entriService.deleteEntri(idEntri);
        return ResponseEntity.noContent().build();
    }
}
