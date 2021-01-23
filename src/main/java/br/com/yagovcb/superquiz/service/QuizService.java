package br.com.yagovcb.superquiz.service;

import br.com.yagovcb.superquiz.model.Quiz;
import br.com.yagovcb.superquiz.model.Respostas;

import java.util.List;

public interface QuizService {

    List<Quiz> findAll();
    Quiz findById(long id);
    Quiz save(Quiz q);
    void validaQuiz(Quiz q, Respostas r) throws Exception;
}
