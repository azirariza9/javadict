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

import com.azirariza.javadict.entity.KelasMakna;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOInsert;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOUpdate;
import com.azirariza.javadict.service.KelasMaknaService;

@RestController
@RequestMapping({ "/api/kelas_makna", "api/kelas_makna/" })
public class KelasMaknaController {
    private final KelasMaknaService kelasMaknaService;

    public KelasMaknaController(KelasMaknaService kelasMaknaService) {
        this.kelasMaknaService = kelasMaknaService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<KelasMakna>> getAllEntri() {
        return ResponseEntity.ok(kelasMaknaService.getAllKelasMakna());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KelasMakna> getEntriById(@PathVariable int id) {
        Optional<KelasMakna> entri = kelasMaknaService.getKelasMaknaById(id);
        return entri.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KelasMakna> createEntri(@RequestBody KelasMaknaDTOInsert kelasMaknaDTO) {
        KelasMakna createdKata = kelasMaknaService.createKelasMakna(kelasMaknaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KelasMakna> updateEntri(@PathVariable int id,
            @RequestBody KelasMaknaDTOUpdate kelasMaknaDTO) {
        return ResponseEntity.ok(kelasMaknaService.updateKelasMakna(id, kelasMaknaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntri(@PathVariable int id) {
        kelasMaknaService.deleteKelasMakna(id);
        return ResponseEntity.noContent().build();
    }
}
