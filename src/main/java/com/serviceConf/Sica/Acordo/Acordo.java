package com.serviceConf.Sica.Acordo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "pub",name = "acordo")
public class Acordo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numacor")
    private Integer numacor;
    @Column(name = "codcia")
    private String codcia;
    @Column(name = "tc")
    private String tc;
    @Column(name = "emiini")
    private Date emiini;
    @Column(name = "emifin")
    private Date emifin;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "valfee")
    private Double valfee;
    @Column(name = "fee")
    private Double fee;
    @Column(name = "maxprpcl")
    private Double maxprpcl;
    @Column(name = "adicrpfn")
    private Double adicrpfn;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "perccmfn")
    private Double perccmfn;
    @Column(name = "percrpfn")
    private Double percrpfn;
    @Column(name = "percovfn")
    private Double percovfn;
    @Column(name = "perccmcl")
    private Double perccmcl;
    @Column(name = "percovcl")
    private Double percovcl;
}
