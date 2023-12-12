package com.serviceConf.confiancaManger.Checkin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "checkin")
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codg_checkin")
    private Integer codgCheckin;
    @Column(name = "id_reserva")
    private String idReserva;
    @Column(name = "trecho")
    private String trecho;
    @Column(name = "nome_agencia")
    private String nomeAgencia;
    @Column(name = "nome_unidade")
    private String nomeUnidade;
    @Column(name = "numero_do_bilhete")
    private String numeroDoBilhete;
    @Column(name = "numero_bilhete_original")
    private String numeroBilheteOriginal;
    @Column(name = "tkt_bilhete")
    private String tktBilhete;
    @Column(name = "logomarca")
    private String logomarca;
    @Column(name = "localizador_companhia")
    private String localizadorCompanhia;
    @Column(name = "data")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date data;
    @Column(name = "companhia")
    private String companhia;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "email")
    private String email;
    @Column(name = "passageiro")
    private String passageiro;
    @Column(name = "reemissao")
    private Integer reemissao;
    @Column(name = "is_envio")
    private Integer isEnvio ;

}
