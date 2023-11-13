package com.serviceConf.wooba.turReservasAereasTrecho;

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
@Table(name = "turReservasAereasTrecho")
public class TurReservasAereasTrecho {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Companhia")
    private String companhia;
    @Column(name = "Data")
    private Date data;
    @Column(name = "DataRetorno")
    private Date dataRetorno;
    @Column(name = "dsDestino")
    private String dsDestino;
    @Column(name = "dsOrigem")
    private String dsOrigem;
    @Column(name = "Familia")
    private String familia;
    @Column(name = "Reserva")
    private Integer reserva;
    @Column(name = "LocalizadorCompanhia")
    private String localizadorCompanhia;
    @Column(name = "Segmento")
    private String segmento;
    @Column(name = "Conexao")
    private Integer conexao;
    @Column(name = "De")
    private String de;
    @Column(name = "Para")
    private String para;
    @Column(name = "DuracaoVoo")
    private String duracaoVoo;
    @Column(name = "Hora")
    private String hora;
    @Column(name = "Voo")
    private String voo;
    @Column(name = "HoraRetorno")
    private String horaRetorno;
}
