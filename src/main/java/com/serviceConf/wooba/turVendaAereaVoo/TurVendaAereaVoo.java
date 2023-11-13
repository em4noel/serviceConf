package com.serviceConf.wooba.turVendaAereaVoo;

import com.serviceConf.wooba.turVendasAereas.TurVendasAereas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turVendaAereaVoo")
public class TurVendaAereaVoo {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "LocalizadorCompanhia")
    private String localizadorCompanhia;
    @Column(name = "conexao")
    private String conexao;
    @Column(name = "Origem")
    private String origem;
    @Column(name = "dsOrigem")
    private String dsOrigem;
    @Column(name = "Destino")
    private String destino;
    @Column(name = "dsDestino")
    private String dsDestino;
    @Column(name = "Companhia")
    private String companhia;
    @Column(name = "Partida")
    private String partida;
    @Column(name = "Chegada")
    private String chegada;
    @Column(name = "HoraDaPartida")
    private String horaDaPartida;
    @Column(name = "Voo")
    private String voo;
    @Column(name = "HoraDaChegada")
    private String horaDaChegada;
    @ManyToOne
    @JoinColumn(name = "Venda")
    private TurVendasAereas venda;
}
