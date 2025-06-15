package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Submakna {
    @JsonProperty("id_submakna")
    private int idSubmakna;
    @JsonProperty("id_makna")
    private int idMakna;
    @JsonProperty("teks")
    private String teks;

    public Submakna() {
    }

    public Submakna(int idSubmakna, int idMakna, String teks) {
        this.idSubmakna = idSubmakna;
        this.idMakna = idMakna;
        this.teks = teks;
    }

    public int getIdSubmakna() {
        return idSubmakna;
    }

    public void setIdSubmakna(int idSubmakna) {
        this.idSubmakna = idSubmakna;
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
