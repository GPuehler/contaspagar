package com.example.contaspagar.controller;


import com.example.contaspagar.model.Pessoa;
import com.example.contaspagar.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/")

public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getAllPessoas (@RequestParam(required = false) String nome) {
        try {
            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            if (nome == null)
                pessoaRepository.findAll().forEach(pessoas::add);
            else
                pessoaRepository.findByNome(nome).forEach(pessoas::add);

            if (pessoas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> createTutorial(@RequestBody Pessoa pessoa) {
        try {

            // Não deixa inserir vazio
            if (pessoa.getNome().isEmpty()) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }

            Pessoa _pessoa = pessoaRepository
                    .save(pessoa);
            return new ResponseEntity<>(_pessoa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
