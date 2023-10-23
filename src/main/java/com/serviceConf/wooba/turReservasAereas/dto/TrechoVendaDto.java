package com.serviceConf.wooba.turReservasAereas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrechoVendaDto {
    private String companhia;
    private Date data;
    private Date dataRetorno;
    private String dsDestino;
    private String dsOrigem;
    private String familia;
    private String trecho;
}
