package com.serviceConf.wooba.turVendasAereas.dto;

import lombok.Data;

@Data
public class FindByLocalizadorDto {
    private String localizador;
    private String numeroDoBilhete;

    public FindByLocalizadorDto(String localizador, String numeroDoBilhete) {
        this.localizador = localizador;
        this.numeroDoBilhete = numeroDoBilhete;
    }
}
