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

import com.azirariza.javadict.entity.Makna;
import com.azirariza.javadict.entity.dto.MaknaDTOInsert;
import com.azirariza.javadict.entity.dto.MaknaDTOUpdate;
import com.azirariza.javadict.service.MaknaService;

@RestController
@RequestMapping({ "/api/makna", "api/makna/" })
public class MaknaController {
    private final MaknaService maknaService;

    public MaknaController(MaknaService maknaService) {
        this.maknaService = maknaService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<Makna>> getAllMakna() {
        return ResponseEntity.ok(maknaService.getAllMakna());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Makna> getMaknaById(@PathVariable int id) {
        Optional<Makna> entri = maknaService.getMaknaById(id);
        return entri.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Makna> createMakna(@RequestBody MaknaDTOInsert maknaDTO) {
        Makna createdKata = maknaService.createMakna(maknaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Makna> updateMakna(@PathVariable int id, @RequestBody MaknaDTOUpdate maknaDTO) {
        return ResponseEntity.ok(maknaService.updateMakna(id, maknaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMakna(@PathVariable int id) {
        maknaService.deleteMakna(id);
        return ResponseEntity.noContent().build();
    }
}
