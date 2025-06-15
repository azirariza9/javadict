package com.azirariza.javadict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.entity.Makna;
import com.azirariza.javadict.entity.dto.MaknaDTOInsert;
import com.azirariza.javadict.entity.dto.MaknaDTOUpdate;
import com.azirariza.javadict.repository.MaknaRepository;

@Service
public class MaknaService {
    private final MaknaRepository maknaRepository;

    public MaknaService(MaknaRepository maknaRepository) {
        this.maknaRepository = maknaRepository;
    }

    public List<Makna> getAllMakna() {
        return maknaRepository.findAll();
    }

    public Optional<Makna> getMaknaById(int id) {
        return maknaRepository.findById(id);
    }

    public Makna createMakna(MaknaDTOInsert maknaDTO) {
        return maknaRepository.insert(maknaDTO);
    }

    public Makna updateMakna(int id, MaknaDTOUpdate maknaDTO) {
        return maknaRepository.update(id, maknaDTO);
    }

    public void deleteMakna(int id) {
        maknaRepository.deleteById(id);
    }

}
