package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntriDTOUpdate {
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("nomor")
    private int nomor;
    @JsonProperty("pelafalan")
    private String pelafalan;

    public EntriDTOUpdate() {
    }

    public EntriDTOUpdate(String nama, int nomor, String pelafalan) {
      
        this.nama = nama;
        this.nomor = nomor;
        this.pelafalan = pelafalan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getPelafalan() {
        return pelafalan;
    }

    public void setPelafalan(String pelafalan) {
        this.pelafalan = pelafalan;
    }
}
