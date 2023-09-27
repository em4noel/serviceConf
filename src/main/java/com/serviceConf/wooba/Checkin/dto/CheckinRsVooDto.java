package com.serviceConf.wooba.Checkin.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class CheckinRsVooDto {
    private String id;
    private String trecho;
    private String nomeAgencia;
    private String nomeUnidade;
    private String numeroBilhete;
    private String logomarca;
    private String localizadorCompanhia;
    private Date partida;
    private String companhia;
    private String nomeEmissor;
    private String email;
    private String passageiro;
    private Integer reemissao;
    private List<TrechoVooDto> trechosIda;
    private List<TrechoVooDto> trechosVolta;
    private List<TrechoVooDto> trechosMultiplaConexao;

    public CheckinRsVooDto(String id, String trecho, String nomeAgencia, String nomeUnidade, String numeroBilhete, String logomarca, String localizadorCompanhia, Date data, String companhia, String nomeEmissor, String email, String passageiro, Integer reemissao) {
        this.id = id;
        this.trecho = trecho;
        this.nomeAgencia = nomeAgencia;
        this.nomeUnidade = nomeUnidade;
        this.numeroBilhete = numeroBilhete;
        this.logomarca = logomarca;
        this.localizadorCompanhia = localizadorCompanhia;
        this.partida = data;
        this.companhia = companhia;
        this.nomeEmissor = nomeEmissor;
        this.email = email;
        this.passageiro = passageiro;
        this.reemissao = reemissao;
        this.trechosIda = new ArrayList<>();
        this.trechosVolta = new ArrayList<>();
        this.trechosMultiplaConexao = new ArrayList<>();
    }
}
