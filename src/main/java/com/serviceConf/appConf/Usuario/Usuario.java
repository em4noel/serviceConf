package com.serviceConf.appConf.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario", schema = "appConf")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codg_usuario;
    @Column
    private String login;
    @Column
    private String senha;
    @Column
    private String role;

}
