package br.com.yagovcb.superquiz.service;


import br.com.yagovcb.superquiz.model.Respostas;

import java.util.List;

public interface RespostaService {

    List<Respostas> findAll();
    Respostas findById(long id);
    Respostas save(Respostas respostas);
}
