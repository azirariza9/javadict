package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContohDTOUpdate {
    @JsonProperty("teks")
    private String teks;

    public ContohDTOUpdate() {
    }

    public ContohDTOUpdate(String teks) {
        this.teks = teks;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }
}
