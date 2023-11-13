package com.serviceConf.wooba.turReservasAereas;

import com.serviceConf.wooba.turUsuarios.TurUsuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turReservasAereas")
public class TurReservasAereas {
    @Id
    @Column(name = "Id")
    private Integer reservaId;
    @Column(name = "Trecho")
    private String trecho;
    @Column(name = "Companhia")
    private String companhia;
    @Column(name = "Cliente")
    private Integer cliente;
    @Column(name = "Localizador")
    private String localizador;
    @Column(name = "Agencia")
    private Integer agencia;
    @JoinColumn(name = "Usuario")
    @ManyToOne
    private TurUsuarios usuario;
}
