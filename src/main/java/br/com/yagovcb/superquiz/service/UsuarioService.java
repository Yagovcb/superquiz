package br.com.yagovcb.superquiz.service;

import br.com.yagovcb.superquiz.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(long id);
    Usuario cadastrar (Usuario usuario);
    Usuario carregaAutorPeloEmail(String email) throws Exception;
}
