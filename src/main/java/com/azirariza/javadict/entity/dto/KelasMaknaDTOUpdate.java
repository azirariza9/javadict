package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KelasMaknaDTOUpdate {
    @JsonProperty("kode")
    private String kode;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("deskripsi")
    private String deskripsi;

    public KelasMaknaDTOUpdate() {
    }

    public KelasMaknaDTOUpdate(String kode, String nama, String deskripsi) {
        this.nama = nama;
        this.kode = kode;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
