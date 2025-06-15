package com.azirariza.javadict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.entity.Contoh;
import com.azirariza.javadict.entity.dto.ContohDTOInsert;
import com.azirariza.javadict.entity.dto.ContohDTOUpdate;
import com.azirariza.javadict.repository.ContohRepository;

@Service
public class ContohService {
    private final ContohRepository contohRepository;

    public ContohService(ContohRepository contohRepository) {
        this.contohRepository = contohRepository;
    }

    public List<Contoh> getAllContoh() {
        return contohRepository.findAll();
    }

    public Optional<Contoh> getContohById(int id) {
        return contohRepository.findById(id);
    }

    public Contoh createContoh(ContohDTOInsert contohDTO) {
        return contohRepository.insert(contohDTO);
    }

    public Contoh updateContoh(int id, ContohDTOUpdate contohDTO) {
        return contohRepository.update(id, contohDTO);
    }

    public void deleteContoh(int id) {
        contohRepository.deleteById(id);
    }

}
