package com.serviceConf.wooba.turAgencias;

import com.serviceConf.wooba.turUnidadesOperacionais.TurUnidadesOperacionais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turAgencias")
public class TurAgencias {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Nome")
    private String nomeAgencia;
    @Column(name = "Logomarca")
    private String logomarca;
    @ManyToOne
    @JoinColumn(name = "Unidade")
    private TurUnidadesOperacionais turUnidadesOperacionais;
    @Column(name = "IdErp")
    private String idErp;
}
