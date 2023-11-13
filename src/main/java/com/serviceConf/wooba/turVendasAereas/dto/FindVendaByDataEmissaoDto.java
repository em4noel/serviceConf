package com.serviceConf.wooba.turVendasAereas.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FindVendaByDataEmissaoDto {
    private Integer id;
    private String localizador;
    private String origem;
    private String destino;
    private BigDecimal tarifa;
    private BigDecimal taxa;
    private String ccRequisicao;
    private Date emitidoEm;
    private Date dataDeEmbarque;
    private String companhia;

    public FindVendaByDataEmissaoDto(Integer id, String localizador, String origem, String destino, BigDecimal tarifa, BigDecimal taxa, String ccRequisicao, Date emitidoEm, Date dataDeEmbarque, String companhia) {
        this.id = id;
        this.localizador = localizador;
        this.origem = origem;
        this.destino = destino;
        this.tarifa = tarifa;
        this.taxa = taxa;
        this.ccRequisicao = ccRequisicao;
        this.emitidoEm = emitidoEm;
        this.dataDeEmbarque = dataDeEmbarque;
        this.companhia = companhia;

    }
}
