package com.serviceConf.wooba.turVendasAereas;

import com.serviceConf.wooba.turAgencias.TurAgencias;
import com.serviceConf.wooba.turUnidadesOperacionais.TurUnidadesOperacionais;
import com.serviceConf.wooba.turUsuarios.TurUsuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turVendasAereas")
public class TurVendasAereas {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "NumeroDaCompanhia")
    private String numeroDaCompanhia;
    @Column(name = "NumeroDoBilhete")
    private String numeroDoBilhete;
    @Column(name = "NumeroBilheteOriginal")
    private String numeroBilheteOriginal;
    @Column(name = "TktBilhete")
    private String tktBilhete;
    @Column(name = "Localizador")
    private String localizador;
    @ManyToOne
    @JoinColumn(name = "Unidade")
    private TurUnidadesOperacionais unidade;
    @ManyToOne
    @JoinColumn(name = "Agencia")
    private TurAgencias agencia;
    @ManyToOne
    @JoinColumn(name = "Usuario")
    private TurUsuarios usuario;
    @Column(name = "Trecho")
    private Integer trecho;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "DataDeEmbarque")
    private Date dataDeEmbarque;
    @Column(name = "DataDaInclusao")
    private Date dataDaInclusao;
    @Column(name = "DataDeAlteracao")
    private Date dataDeAlteracao;
    @Column(name = "Passageiro")
    private String passageiro;
    @Column(name = "Companhia")
    private String companhia;
    @Column(name = "Cliente")
    private Integer cliente;
    @Column(name = "EmitidoEm")
    private Date emitidoEm;
    @Column(name = "Reemissao")
    private Integer reemissao;
    @Column(name = "ReemissaoTipo")
    private Integer reemissaoTipo;
    @Column(name = "Origem")
    private String origem;
    @Column(name = "Destino")
    private String destino;
    @Column(name = "Tarifa")
    private BigDecimal tarifa;
    @Column(name = "Taxa")
    private BigDecimal taxa;
    @Column(name = "ccRequisicao")
    private String ccRequisicao;
    @Column(name = "TipoDePassageiro")
    private String tipoDePassageiro;
    @Column(name = "TaxaRepasseDeTerceiros")
    private BigDecimal taxaRepasseDeTerceiros;
    @Column(name = "PassageiroSexo")
    private String passageiroSexo;
    @Column(name = "Requisicao")
    private String requisicao;
}
