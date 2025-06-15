package com.azirariza.javadict.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaknaDTOUpdate {

    @JsonProperty("info")
    private String info;

    public MaknaDTOUpdate() {
    }

    public MaknaDTOUpdate(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
