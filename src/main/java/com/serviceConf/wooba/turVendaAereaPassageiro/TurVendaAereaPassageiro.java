package com.serviceConf.wooba.turVendaAereaPassageiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turVendaAereaPassageiro")
public class TurVendaAereaPassageiro {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Venda")
    private Integer venda;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Bilhete")
    private String bilhete;
    @Column(name = "Tarifa")
    private BigDecimal tarifa;
    @Column(name = "Taxa")
    private BigDecimal taxa;
    @Column(name = "TaxaRepasseDeTerceiros")
    private BigDecimal taxaRepasseDeTerceiros;
    @Column(name = "PassageiroSexo")
    private String passageiroSexo;

}
