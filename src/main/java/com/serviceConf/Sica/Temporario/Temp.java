package com.serviceConf.Sica.Temporario;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(schema = "pub",name = "temptkt")
public class Temp {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "numvend")
    private Integer Id;
    @Column(name = "numtkt")
    private String numtkt;
    @Column(name = "loc")
    private String loc;
}
