package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaknaDTOInsert {

    @JsonProperty("id_entri")
    private int idEntri;
    @JsonProperty("info")
    private String info;

    public MaknaDTOInsert() {
    }

    public MaknaDTOInsert(int idEntri, String info) {
        this.idEntri = idEntri;
        this.info = info;
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
