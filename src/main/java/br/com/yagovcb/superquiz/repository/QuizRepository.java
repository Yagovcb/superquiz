package br.com.yagovcb.superquiz.repository;

import br.com.yagovcb.superquiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
