package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kata {
    @JsonProperty("id_kata")
    private String idKata;
    @JsonProperty("pranala")
    private String pranala;

    public Kata() {}
    public Kata(String idKata,String pranala){
        this.idKata = idKata;
        this.pranala = pranala;
    }
    public String getIdKata(){return idKata;}
    public void setIdKata(String idKata){this.idKata=idKata;}
    public String getPranala(){return pranala;}
    public void setPranala(String pranala){this.pranala=pranala;}
}
