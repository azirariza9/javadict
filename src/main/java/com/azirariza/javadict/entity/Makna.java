package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Makna {
    @JsonProperty("id_makna")
    private int idMakna;
    @JsonProperty("id_entri")
    private int idEntri;
    @JsonProperty("info")
    private String info;

    public Makna() {
    }

    public Makna(int idMakna, int idEntri, String info) {
        this.idMakna = idMakna;
        this.idEntri = idEntri;
        this.info = info;
    }

    public int getIdMakna() {
        return idMakna;
    }

    public void setIdMakna(int idMakna) {
        this.idMakna = idMakna;
    }

    public int getIdEntri() {
        return idEntri;
    }

    public void setIdEntri(int idEntri) {
        this.idEntri = idEntri;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
