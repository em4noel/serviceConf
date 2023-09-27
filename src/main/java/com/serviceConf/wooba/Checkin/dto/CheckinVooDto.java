package com.serviceConf.wooba.Checkin.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CheckinVooDto {
    private Integer vooId;
    private String passageiro;
    private Integer trecho;
    private String nomeAgencia;
    private String nomeUnidade;
    private String logomarca;
    private String nomeEmissor;
    private String email;
    private String numeroDoBilhete;
    private String localizador;
    private String localizadorCompanhia;
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
    private Integer status;
    private Integer reemissao;
}
