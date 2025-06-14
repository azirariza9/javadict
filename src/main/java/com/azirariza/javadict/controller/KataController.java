package com.azirariza.javadict.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azirariza.javadict.entity.Kata;
import com.azirariza.javadict.service.KataService;

@RestController
@RequestMapping({"/api/kata","api/kata/"})
public class KataController {
    private final KataService kataService;

    public KataController(KataService kataService) {
        System.out.println("KataController initialized!");
        this.kataService = kataService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }

    @GetMapping
    public ResponseEntity<List<Kata>> getAllKata() {
        return ResponseEntity.ok(kataService.getAllKata());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kata> getKataById(@PathVariable String id) {
        Optional<Kata> kata = kataService.getKataById(id);
        return kata.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kata> createKata(@RequestBody Kata kata) {
        Kata createdKata = kataService.createKata(kata);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kata> updateKata(@PathVariable String id, @RequestBody Kata kata) {
        return ResponseEntity.ok(kataService.updateKata(id, kata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKata(@PathVariable String id) {
        kataService.deleteKata(id);
        return ResponseEntity.noContent().build();
    }
}
