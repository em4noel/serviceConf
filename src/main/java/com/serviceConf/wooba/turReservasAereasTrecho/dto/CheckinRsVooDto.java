package com.serviceConf.wooba.turReservasAereasTrecho.dto;

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
    private String numeroBilheteOriginal;
    private String tktBilhete;
    private String logomarca;
    private String localizadorCompanhia;
    private Date data;
    private String companhia;
    private String nomeCompleto;
    private String email;
    private String passageiro;
    private Integer reemissao;
    private List<TrechoVooDto> trechosIda;
    private List<TrechoVooDto> trechosVolta;
    private List<TrechoVooDto> trechosMultiplaConexao;

    public CheckinRsVooDto(String id, String numeroBilhete,String tktBilhete, String localizadorCompanhia, Date data, String companhia, String nomeAgencia, String nomeUnidade,  String logomarca, String nomeCompleto, String email, String passageiro, String trecho, Integer reemissao) {
        this.id = id;
        this.numeroBilheteOriginal = numeroBilhete;
        this.tktBilhete= tktBilhete;
        this.localizadorCompanhia = localizadorCompanhia;
        this.data = data;
        this.companhia = companhia;
        this.nomeAgencia = nomeAgencia;
        this.nomeUnidade = nomeUnidade;
        this.logomarca = logomarca;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.passageiro = passageiro;
        this.trecho = trecho;
        this.reemissao = reemissao;
        this.trechosIda = new ArrayList<>(); // Inicializa a lista de trechos de ida
        this.trechosVolta = new ArrayList<>(); // Inicializa a lista de trechos de volta
        this.trechosMultiplaConexao = new ArrayList<>();
    }
}
