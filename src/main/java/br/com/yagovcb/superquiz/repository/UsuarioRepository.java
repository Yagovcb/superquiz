package br.com.yagovcb.superquiz.repository;

import br.com.yagovcb.superquiz.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    Usuario findByNome(String nome);
}
