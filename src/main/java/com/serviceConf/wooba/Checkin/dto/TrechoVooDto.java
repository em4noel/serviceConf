package com.serviceConf.wooba.Checkin.dto;

import lombok.Data;

import java.util.Date;
@Data
public class TrechoVooDto {
    private Integer conexao;
    private String origem;
    private String dsOrigem;
    private String destino;
    private String dsDestino;
    private String companhia;
    private Date partida;
    private Date chegada;
    private String horaDaPartida;
    private String voo;
    private String horaDaChegada;
    private Integer reemissao;
}
