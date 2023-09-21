package com.serviceConf.Bi.Rot.dto;

public class RotDTO {

    private String fatura;

    public RotDTO() {
    }

    public RotDTO(String fatura) {
        this.fatura = fatura;

    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }


    @Override
    public String toString() {
        return "RotDTO [fatura=" + fatura + "]";
    }
}
