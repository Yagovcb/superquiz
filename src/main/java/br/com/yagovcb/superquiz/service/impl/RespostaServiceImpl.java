package br.com.yagovcb.superquiz.service.impl;

import br.com.yagovcb.superquiz.model.Respostas;
import br.com.yagovcb.superquiz.repository.RespostaRepository;
import br.com.yagovcb.superquiz.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaServiceImpl implements RespostaService {
    @Autowired
    private RespostaRepository repository;

    @Override
    public List<Respostas> findAll() {
        return repository.findAll();
    }

    @Override
    public Respostas findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Respostas save(Respostas respostas) {
        return repository.save(respostas);
    }
}
