package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KelasMakna {
    @JsonProperty("id_kelas_makna")
    private int idKelasMakna;
    @JsonProperty("id_makna")
    private int idMakna;
    @JsonProperty("kode")
    private String kode;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("deskripsi")
    private String deskripsi;

    public KelasMakna() {
    }

    public KelasMakna(int idKelasMakna, int idMakna, String kode, String nama, String deskripsi) {
        this.idKelasMakna = idKelasMakna;
        this.idMakna = idMakna;
        this.nama = nama;
        this.kode = kode;
        this.deskripsi = deskripsi;
    }

    public int getidKelasMakna() {
        return idKelasMakna;
    }

    public void setidKelasMakna(int idKelasMakna) {
        this.idKelasMakna = idKelasMakna;
    }

    public int getidMakna() {
        return idMakna;
    }

    public void setidMakna(int idMakna) {
        this.idMakna = idMakna;
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
