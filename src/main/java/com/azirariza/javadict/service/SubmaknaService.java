package com.azirariza.javadict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azirariza.javadict.entity.Submakna;
import com.azirariza.javadict.entity.dto.SubmaknaDTOInsert;
import com.azirariza.javadict.entity.dto.SubmaknaDTOUpdate;
import com.azirariza.javadict.repository.SubmaknaRepository;

@Service
public class SubmaknaService {
    private final SubmaknaRepository submaknaRepository;

    public SubmaknaService(SubmaknaRepository submaknaRepository) {
        this.submaknaRepository = submaknaRepository;
    }

    public List<Submakna> getAllSubmakna() {
        return submaknaRepository.findAll();
    }

    public Optional<Submakna> getSubmaknaById(int id) {
        return submaknaRepository.findById(id);
    }

    public Submakna createSubmakna(SubmaknaDTOInsert submaknaDTO) {
        return submaknaRepository.insert(submaknaDTO);
    }

    public Submakna updateSubmakna(int id, SubmaknaDTOUpdate submaknaDTO) {
        return submaknaRepository.update(id, submaknaDTO);
    }

    public void deleteSubmakna(int id) {
        submaknaRepository.deleteById(id);
    }

}
