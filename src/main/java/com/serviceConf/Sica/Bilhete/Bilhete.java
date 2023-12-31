package com.serviceConf.Sica.Bilhete;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "pub",name = "bilhete")
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numvend")
    private Integer numvend;
    @Column(name = "loc")
    private String loc;
    @Column(name = "numtkt")
    private String numtkt;
    @Column(name = "codest")
    private String codest;
    @Column(name = "pax")
    private String pax;
    @Column(name = "iata")
    private Integer iata;
}
