package com.azirariza.javadict.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntriDTOInsert {
    @JsonProperty("id_kata")
    private String idKata;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("nomor")
    private int nomor;
    @JsonProperty("pelafalan")
    private String pelafalan;

    public EntriDTOInsert() {
    }

    public EntriDTOInsert(String idKata, String nama, int nomor, String pelafalan) {

        this.idKata = idKata;
        this.nama = nama;
        this.nomor = nomor;
        this.pelafalan = pelafalan;
    }

    public String getIdKata() {
        return idKata;
    }

    public void setIdKata(String idKata) {
        this.idKata = idKata;
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
