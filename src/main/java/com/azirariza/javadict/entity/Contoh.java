package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contoh {
    @JsonProperty("id_contoh")
    private int idContoh;
    @JsonProperty("id_makna")
    private int idMakna;
    @JsonProperty("teks")
    private String teks;

    public Contoh() {
    }

    public Contoh(int idContoh, int idMakna, String teks) {
        this.idContoh = idContoh;
        this.idMakna = idMakna;
        this.teks = teks;
    }

    public int getIdContoh() {
        return idContoh;
    }

    public void setIdContoh(int idContoh) {
        this.idContoh = idContoh;
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
