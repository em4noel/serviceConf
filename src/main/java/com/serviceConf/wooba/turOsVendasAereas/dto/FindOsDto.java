package com.serviceConf.wooba.turOsVendasAereas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FindOsDto {
    private String numero;
    private Date dataAbertura;
    private Date dataViagem;
    private Integer passageiro;
    private String descricao;
    private String solicitanteNome;
    private String solicitanteEmail;
    private String campoExtra1Descricao;
    private String campoExtra2Valor;
    private String campoExtra3Descricao;
    private String campoExtra4Descricao;
    private String campoExtra5Valor;
    private Integer id;

    public FindOsDto(String numero, Date dataAbertura, Date dataViagem, Integer passageiro, String descricao, String solicitanteNome, String solicitanteEmail, String campoExtra1Descricao, String campoExtra2Valor, String campoExtra3Descricao, String campoExtra4Descricao, String campoExtra5Valor, Integer id) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataViagem = dataViagem;
        this.passageiro = passageiro;
        this.descricao = descricao;
        this.solicitanteNome = solicitanteNome;
        this.solicitanteEmail = solicitanteEmail;
        this.campoExtra1Descricao = campoExtra1Descricao;
        this.campoExtra2Valor = campoExtra2Valor;
        this.campoExtra3Descricao = campoExtra3Descricao;
        this.campoExtra4Descricao = campoExtra4Descricao;
        this.campoExtra5Valor = campoExtra5Valor;
        this.id = id;
    }
}
