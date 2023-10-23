package com.serviceConf.wooba.ccrPassageiros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CcrPassageiroDto {
    private String nome;
    private String sobrenome;
    private String nomeDoMeio;
    private String cpf;
    private Date nascimento;
    private String rua;
    private String bairro;
    private String cidadeNome;
    private String celular;
    private String cargo;
    private String matricula;
    private String notas;
    private String apelido;
}
