package br.com.yagovcb.superquiz.service.impl;

import br.com.yagovcb.superquiz.model.Usuario;
import br.com.yagovcb.superquiz.model.UsuarioUserDetail;
import br.com.yagovcb.superquiz.repository.UsuarioRepository;
import br.com.yagovcb.superquiz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario carregaAutorPeloEmail(String email) throws Exception {
        Usuario usuario = repository.findByEmail(email);
        if (Objects.isNull(usuario)){
            throw new Exception("Não existe usuario cadastrado com esse email! " + email);
        }
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = repository.findByNome(s);
        if (Objects.isNull(usuario)){
            throw new UsernameNotFoundException("Usuario não existe!" + usuario);
        }
        return new UsuarioUserDetail(usuario);
    }
}
