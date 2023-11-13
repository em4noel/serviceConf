package com.serviceConf.wooba.turReservasAereas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class TrechoVendaDto {
    private String trecho;
    private String companhia;
    private Date data;
    private Date dataRetorno;
    private String dsDestino;
    private String dsOrigem;
    private String familia;


    public TrechoVendaDto(String trecho, String companhia, Date data, Date dataRetorno, String dsDestino, String dsOrigem, String familia) {
        this.trecho = trecho;
        this.companhia = companhia;
        this.data = data;
        this.dataRetorno = dataRetorno;
        this.dsDestino = dsDestino;
        this.dsOrigem = dsOrigem;
        this.familia = familia;
    }
}
