package br.com.yagovcb.superquiz.controller;

import br.com.yagovcb.superquiz.model.Usuario;
import br.com.yagovcb.superquiz.repository.UsuarioRepository;
import br.com.yagovcb.superquiz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;


    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        usuario = this.repository.save(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<Usuario> edit(@RequestBody Usuario usuario){
        usuario = this.repository.save(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN","ROLE_CLIENT"})
    @GetMapping
    public ResponseEntity<Page<Usuario>> list(@RequestParam("page") int page, @RequestParam("size") int size ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<Page<Usuario>>(repository.findAll(pageable), HttpStatus.OK);
    }
}
