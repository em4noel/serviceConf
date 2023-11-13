package com.serviceConf.wooba.turReservasAereasTrecho.dto;

import lombok.Data;

import java.util.Date;
@Data
public class TrechoVooDto {
    private Integer conexao;
    private String de;
    private String dsOrigem;
    private String para;
    private String dsDestino;
    private String companhia;
    private String duracaoVoo;
    private String hora;
    private String voo;
    private String horaRetorno;
    private Integer status;
    private Date data;
    private Integer reemissao;
    private Integer idTrecho;

    public TrechoVooDto(Integer conexao,  String de, String dsOrigem, String para, String dsDestino,String companhia, String duracaoVoo, String hora, String voo, String horaRetorno, Integer status, Date data, Integer reemissao,Integer idTrecho) {
        this.conexao = conexao;
        this.de = de;
        this.dsOrigem = dsOrigem;
        this.para = para;
        this.dsDestino = dsDestino;
        this.companhia = companhia;
        this.duracaoVoo = duracaoVoo;
        this.hora = hora;
        this.voo = voo;
        this.horaRetorno = horaRetorno;
        this.status = status;
        this.data = data;
        this.reemissao = reemissao;
        this.idTrecho=idTrecho;
    }

    public TrechoVooDto() {

    }
}
