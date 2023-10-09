package com.serviceConf.Sica.Venda;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "pub",name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numvend")
    private Integer numvend;
    @Column(name = "codemp")
    private Integer codemp;

}
