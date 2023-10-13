package com.serviceConf.Sica.Venda;

import com.serviceConf.Sica.Bilhete.Bilhete;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

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
    @Column(name = "totrpfn")
    private Double totrpfn;
    @Column(name = "codest")
    private String codest;
    @Column(name = "totaltrf")
    private Double totaltrf;
}
