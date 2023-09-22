package com.serviceConf.appConf.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByLogin(String login);

    Usuario findByLoginAndSenha(String login, String senha);
}
