package com.serviceConf.confiancaManger.Trecho.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TrechoCheckinDto {
    private int codgTrecho;
    private int conexao;
    private String de;
    private String dsOrigem;
    private String para;
    private String dsDestino;
    private String companhia;
    private String duracaoVoo;
    private String hora;
    private String voo;
    private String horaRetorno;
    private int status;
    private Date data;
    private int reemissao;
}
