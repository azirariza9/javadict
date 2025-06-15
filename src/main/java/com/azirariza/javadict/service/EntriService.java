package com.azirariza.javadict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.entity.Entri;
import com.azirariza.javadict.entity.dto.EntriDTOInsert;
import com.azirariza.javadict.entity.dto.EntriDTOUpdate;
import com.azirariza.javadict.repository.EntriRepository;

@Service
public class EntriService {
    private final EntriRepository entriRepository;

    public EntriService(EntriRepository entriRepository) {
        this.entriRepository = entriRepository;
    }

    public List<Entri> getAllEntri() {
        return entriRepository.findAll();
    }

    public Optional<Entri> getEntriById(String id) {
        return entriRepository.findById(id);
    }

    public Entri createEntri(EntriDTOInsert entriDTO) {
        return entriRepository.insert(entriDTO);
    }

    public Entri updateEntri(int idEntri, EntriDTOUpdate entriDTO) {
        return entriRepository.update(idEntri, entriDTO);
    }

    public void deleteEntri(int idEntri) {
        entriRepository.deleteById(idEntri);
    }

}
