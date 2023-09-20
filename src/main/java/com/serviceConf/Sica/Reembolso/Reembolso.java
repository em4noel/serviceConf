package com.serviceConf.Sica.Reembolso;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "pub",name = "reembolso")
public class Reembolso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numreemb")
    private Integer numreemb;
    @Column(name = "dataped")
    private Date dataped;
    @Column(name = "numtkt")
    private String numtkt;
    @Column(name = "cartao")
    private Boolean cartao;
    @Column(name = "pax")
    private String pax;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "datareg")
    private Date datareg;
    @Column(name = "codemp")
    private Integer codemp;
    @Column(name = "codcia")
    private String codcia;
    @Column(name = "dataemi")
    private Date dataemi;
    @Column(name = "datalibe")
    private Date datalibe;
    @Column(name = "dataree")
    private Date dataree;
    @Column(name = "liberado")
    private Boolean liberado;
    @Column(name = "numvend")
    private Integer numvend;
    @Column(name = "reembolsado")
    private Boolean reembolsado;
    @Column(name = "rvalcmcl")
    private Double rvalcmcl;
    @Column(name = "rvalrpcl")
    private Double rvalrpcl;
    @Column(name = "rvalrpfn")
    private Double rvalrpfn;
    @Column(name = "texto")
    private String texto;
    @Column(name = "valclie")
    private Double valclie;
    @Column(name = "valtxadm")
    private Double valtxadm;
    @Column(name = "vlcartao")
    private Double vlcartao;
    @Column(name = "cancelado")
    private Boolean cancelado;
    @Column(name = "loc")
    private String loc;
    @Column(name = "recnsica")
    private int recnsica;
    @Column(name = "multclie")
    private Double multclie;
    @Column(name = "tarifbrl")
    private Double tarifbrl;
    @Column(name = "taxbrl")
    private Double taxbrl;
    @Column(name = "trfadic")
    private Double trfAdic;
    @Column(name = "trfadbrl")
    private Double trfadbrl;
    @Column(name = "valpaxcl")
    private Double valpaxcl;
    @Column(name = "multforn")
    private Double multforn;
    @Column(name = "tipodoc")
    private String tipodoc;
    @Column(name = "processado")
    private Boolean processado;
    @Column(name = "obs")
    private String obs;
    @Column(name = "importado")
    private Boolean importado;
    @Column(name = "solicitado")
    private Boolean solicitado;

}
