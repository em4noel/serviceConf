package com.serviceConf.wooba.turReservasAereasTrecho.dto;


import lombok.Data;

import java.util.Date;
@Data
public class CheckinVooDto {
    private Integer id;
    private Integer trecho;
    private String nomeAgencia;
    private String nomeUnidade;
    private String logomarca;
    private  String nomeCompleto;
    private  String email;
    private Integer reservaId;
    private String numeroDaCompanhia;
    private String numeroBoBilhete;
    private String numeroBilheteOriginal;
    private String tktBilhete;
    private String localizador;
    private String localizadorCompanhia;
    private String segmento;
    private Integer conexao;
    private String de;
    private String dsOrigem;
    private String para;
    private String dsDestino;
    private String companhia;
    private String duracaoVoo;
    private Date data;
    private Date dataDaInclusao;
    private Date dataDeAlteracao;
    private String hora;
    private String voo;
    private String horaRetorno;
    private Integer status;
    private String passageiro;
    private Integer reemissao;
    private  Integer reemissaoTipo;

    public CheckinVooDto(Integer id, Integer trecho, String nomeAgencia, String nomeUnidade, String logomarca, String nomeCompleto, String email, Integer reservaId, String numeroDaCompanhia, String numeroBoBilhete, String numeroBilheteOriginal, String tktBilhete, String localizador, String localizadorCompanhia, String segmento, Integer conexao, String de, String dsOrigem, String para, String dsDestino, String companhia, String duracaoVoo, Date data, Date dataDaInclusao, Date dataDeAlteracao, String hora, String voo, String horaRetorno, Integer status, String passageiro, Integer reemissao, Integer reemissaoTipo) {
        this.id = id;
        this.trecho = trecho;
        this.nomeAgencia = nomeAgencia;
        this.nomeUnidade = nomeUnidade;
        this.logomarca = logomarca;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.reservaId = reservaId;
        this.numeroDaCompanhia = numeroDaCompanhia;
        this.numeroBoBilhete = numeroBoBilhete;
        this.numeroBilheteOriginal = numeroBilheteOriginal;
        this.tktBilhete = tktBilhete;
        this.localizador = localizador;
        this.localizadorCompanhia = localizadorCompanhia;
        this.segmento = segmento;
        this.conexao = conexao;
        this.de = de;
        this.dsOrigem = dsOrigem;
        this.para = para;
        this.dsDestino = dsDestino;
        this.companhia = companhia;
        this.duracaoVoo = duracaoVoo;
        this.data = data;
        this.dataDaInclusao = dataDaInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
        this.hora = hora;
        this.voo = voo;
        this.horaRetorno = horaRetorno;
        this.status = status;
        this.passageiro = passageiro;
        this.reemissao = reemissao;
        this.reemissaoTipo = reemissaoTipo;
    }
}
