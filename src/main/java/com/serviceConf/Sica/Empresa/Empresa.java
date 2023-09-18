package com.serviceConf.Sica.Empresa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "pub", name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codemp")
    private Integer codemp;
    @Column(name = "nchave")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "UF")
    private String UF;
    @Column(name = "cep")
    private String cep;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "fone2")
    private String fone2;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "email")
    private String email;
    @Column(name = "condpag")
    private Integer condpag;
    @Column(name = "codest")
    private String codest;
    @Column(name = "Ativo")
    private Boolean Ativo;


}
