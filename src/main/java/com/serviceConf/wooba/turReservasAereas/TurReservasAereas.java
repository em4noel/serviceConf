package com.serviceConf.wooba.turReservasAereas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turVendasAereas")
public class TurReservasAereas {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Trecho")
    private String trecho;
    @Column(name = "Companhia")
    private String companhia;
    @Column(name = "Cliente")
    private Integer cliente;
    @Column(name = "Localizador")
    private String localizador;
}
