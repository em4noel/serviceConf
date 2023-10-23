package com.serviceConf.wooba.turOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turOS")
public class TurOS {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Numero")
    private String numero;
    @Column(name = "DataAbertura")
    private Date dataAbertura;
    @Column(name = "DataViagem")
    private Date dataViagem;
    @Column(name = "Passageiro")
    private Integer passageiro;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "SolicitanteNome")
    private String solicitanteNome;
    @Column(name = "SolicitanteEmail")
    private String solicitanteEmail;
    @Column(name = "CampoExtra1Descricao")
    private String campoExtra1Descricao;
    @Column(name = "CampoExtra2Valor")
    private String campoExtra2Valor;
    @Column(name = "CampoExtra3Descricao")
    private String campoExtra3Descricao;
    @Column(name = "CampoExtra4Descricao")
    private String campoExtra4Descricao;

}
