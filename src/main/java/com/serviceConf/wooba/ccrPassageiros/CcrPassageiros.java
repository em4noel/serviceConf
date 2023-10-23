package com.serviceConf.wooba.ccrPassageiros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ccrPassageiros")
public class CcrPassageiros {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Sobrenome")
    private String sobrenome;
    @Column(name = "NomeDoMeio")
    private String nomeDoMeio;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "Nascimento")
    private Date nascimento;
    @Column(name = "Rua")
    private String rua;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "CidadeNome")
    private String cidadeNome;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Notas")
    private String notas;
    @Column(name = "Apelido")
    private String apelido;
}
