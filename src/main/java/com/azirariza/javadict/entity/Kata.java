package com.azirariza.javadict.entity;

public class Kata {
    private String id_kata;
    private String pranala;

    public Kata() {}
    public Kata(String id_kata,String pranala){
        this.id_kata = id_kata;
        this.pranala = pranala;
    }
    public String getIdKata(){return id_kata;}
    public void setIdKata(String id_kata){this.id_kata=id_kata;}
    public String getPranala(){return pranala;}
    public void setPranala(String pranala){this.pranala=pranala;}
}
