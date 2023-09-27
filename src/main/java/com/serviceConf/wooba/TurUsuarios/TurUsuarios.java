package com.serviceConf.wooba.TurUsuarios;

import com.serviceConf.wooba.TurAgencias.TurAgencias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turUsuarios")
public class TurUsuarios {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "NomeCompleto")
    private String nomeCompleto;
    @Column(name = "Email")
    private String email;
    @Column(name = "Status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "Agencia")
    private TurAgencias agencia;
}
