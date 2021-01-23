package br.com.yagovcb.superquiz.service.impl;

import br.com.yagovcb.superquiz.model.Quiz;
import br.com.yagovcb.superquiz.model.Respostas;
import br.com.yagovcb.superquiz.repository.QuizRepository;
import br.com.yagovcb.superquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository repositorio;

    @Override
    public List<Quiz> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Quiz findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Quiz save(Quiz q) {
        return repositorio.save(q);
    }

    @Override
    public void validaQuiz(Quiz q, Respostas r) throws Exception {

        for (Respostas resposta: q.getRespostas()) {
//            if (!resposta.getIsCerta().equals(r.getIsCerta())){
//                throw new Exception("Infelizmente você não acertou a resposta correta!" + q);
//            } else {
//                throw new Exception("Parabéns, resposta correta!");
//            }
        }
    }
}
