package com.serviceConf.wooba.turVendasAereas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FindByLocalizadorDto {
    private String localizador;
    private String numeroDoBilhete;
    private String passageiro;

    public FindByLocalizadorDto(String localizador, String numeroDoBilhete, String passageiro) {
        this.localizador = localizador;
        this.numeroDoBilhete = numeroDoBilhete;
        this.passageiro = passageiro;
    }
}
