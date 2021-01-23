package br.com.yagovcb.superquiz.repository;


import br.com.yagovcb.superquiz.model.Respostas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Respostas, Long> {
}
