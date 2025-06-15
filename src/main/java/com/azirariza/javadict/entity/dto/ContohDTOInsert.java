package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContohDTOInsert {
    @JsonProperty("id_makna")
    private int idMakna;
    @JsonProperty("teks")
    private String teks;

    public ContohDTOInsert() {
    }

    public ContohDTOInsert(int idMakna, String teks) {
        this.idMakna = idMakna;
        this.teks = teks;
    }

    public int getIdMakna() {
        return idMakna;
    }

    public void setIdMakna(int idMakna) {
        this.idMakna = idMakna;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }
}
