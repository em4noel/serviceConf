package com.serviceConf.wooba.TurVendasAereas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DataEmissaoRQ {
    private Date dataInicial;
    private Date dataFinal;
}
