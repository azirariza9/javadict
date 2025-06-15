package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmaknaDTOUpdate {
    @JsonProperty("teks")
    private String teks;

    public SubmaknaDTOUpdate() {
    }

    public SubmaknaDTOUpdate(String teks) {
        this.teks = teks;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }
}
