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

    public String getkode() {
        return kode;
    }

    public void setkode(String kode) {
        this.kode = kode;
    }

    public String getdeskripsi() {
        return deskripsi;
    }

    public void setdeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
