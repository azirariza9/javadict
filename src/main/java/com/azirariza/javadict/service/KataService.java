package com.azirariza.javadict.service;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.repository.KataRepository;
import com.azirariza.javadict.entity.Kata;

import java.util.List;
import java.util.Optional;

@Service
public class KataService {
    private final KataRepository kataRepository;

    public KataService(KataRepository kataRepository) {
        this.kataRepository = kataRepository;
        System.out.println("KataService initialized!");
    }

    public List<Kata> getAllKata() {
        return kataRepository.findAll();
    }

    public Optional<Kata> getKataById(String id) {
        return kataRepository.findById(id);
    }

    public Kata createKata(Kata kata) {
        return kataRepository.insert(kata);
    }

    public Kata updateKata(String id, Kata kataDTO) {
        kataDTO.setIdKata(id); 
        return kataRepository.update(kataDTO);
    }

    public void deleteKata(String id) {
        kataRepository.deleteById(id);
    }

}
