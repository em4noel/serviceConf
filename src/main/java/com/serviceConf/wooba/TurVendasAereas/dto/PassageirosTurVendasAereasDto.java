package com.serviceConf.wooba.TurVendasAereas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassageirosTurVendasAereasDto {
    private String passageiro;
    private String tipoDePassageiro;
    private String numeroDoBilhete;
    private BigDecimal tarifa;
    private BigDecimal taxa;
    private BigDecimal taxaRepasseDeTerceiros;
    private String passageiroSexo;
   private String requisicao;

}
