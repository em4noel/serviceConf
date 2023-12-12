package com.serviceConf.confiancaManger.Trecho;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serviceConf.confiancaManger.Checkin.Checkin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "trecho_checkin")
public class TrechoCheckin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codg_trecho")
    private int codgTrecho;
    @ManyToOne
    @JoinColumn(name = "codg_checkin")
    private Checkin checkin;
    @Column(name = "conexao")
    private int conexao;
    @Column(name = "de")
    private String de;
    @Column(name = "dsOrigem")
    private String dsOrigem;
    @Column(name = "para")
    private String para;
    @Column(name = "dsDestino")
    private String dsDestino;
    @Column(name = "companhia")
    private String companhia;
    @Column(name = "duracao_voo")
    private String duracaoVoo;
    @Column(name = "hora")
    private String hora;
    @Column(name = "voo")
    private String voo;
    @Column(name = "hora_retorno")
    private String horaRetorno;
    @Column(name = "status")
    private int status;
    @Column(name = "data_embarque")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date data;
    @Column(name = "reemissao")
    private int reemissao;
}
