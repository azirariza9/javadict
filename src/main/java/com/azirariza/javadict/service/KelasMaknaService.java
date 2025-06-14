package com.azirariza.javadict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.entity.KelasMakna;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOInsert;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOUpdate;
import com.azirariza.javadict.repository.KelasMaknaRepository;

@Service
public class KelasMaknaService {
    private final KelasMaknaRepository kelasMaknaRepository;

    public KelasMaknaService(KelasMaknaRepository kelasMaknaRepository) {
        this.kelasMaknaRepository = kelasMaknaRepository;
    }

    public List<KelasMakna> getAllKelasMakna() {
        return kelasMaknaRepository.findAll();
    }

    public Optional<KelasMakna> getKelasMaknaById(int id) {
        return kelasMaknaRepository.findById(id);
    }

    public KelasMakna createKelasMakna(KelasMaknaDTOInsert kelasMaknaDTO) {
        return kelasMaknaRepository.insert(kelasMaknaDTO);
    }

    public KelasMakna updateKelasMakna(int id, KelasMaknaDTOUpdate kelasMaknaDTO) {
        return kelasMaknaRepository.update(id, kelasMaknaDTO);
    }

    public void deleteKelasMakna(int id) {
        kelasMaknaRepository.deleteById(id);
    }

}
