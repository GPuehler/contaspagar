package com.example.contaspagar.controller;

import com.example.contaspagar.model.ContaPagar;
import com.example.contaspagar.model.Despesa;
import com.example.contaspagar.model.Pessoa;
import com.example.contaspagar.repository.DespesaRepository;
import com.example.contaspagar.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/despesa")
    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    @PostMapping("/despesa")
    public ResponseEntity<Despesa> createDespesa(@RequestBody Despesa despesa) {
        try {
            Despesa _despesa = despesaRepository
                    .save(despesa);
            return new ResponseEntity<>(despesa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
