package com.serviceConf.Sica.Reembolso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReembolsoDTO implements Serializable {

    private Integer numreemb;

    private Date dataped;

    private String numtkt;

    private Boolean cartao;

    private String pax;

    private String usuario;

    private Date datareg;

    private Integer codemp;

    private String codcia;

    private Date dataemi;

    private Date datalibe;

    private Date dataree;

    private Boolean liberado;

    private Integer numvend;

    private Boolean reembolsado;

    private Double rvalcmcl;

    private Double rvalrpcl;

    private Double rvalrpfn;

    private String texto;

    private Double valclie;

    private Double valtxadm;

    private Double vlcartao;

    private Boolean cancelado;

    private String loc;

    private int recnsica;

    private Double multclie;

    private Double tarifbrl;

    private Double taxbrl;

    private Double trfAdic;

    private Double trfadbrl;

    private Double valpaxcl;

    private Double multforn;

    private String tipodoc;

    private Boolean processado;

    private String obs;

    private Boolean importado;

    private Boolean solicitado;
}
