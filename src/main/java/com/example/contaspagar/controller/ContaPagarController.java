package com.example.contaspagar.controller;

import com.example.contaspagar.model.ContaPagar;
import com.example.contaspagar.repository.ContaPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/")
public class ContaPagarController {

    @Autowired
    private ContaPagarRepository repository;

    @PostMapping("/contapagar")
    public ResponseEntity<ContaPagar> save(@RequestBody ContaPagar contaPagar) {
        ContaPagar conta = repository.save(contaPagar);
        return ResponseEntity.ok(conta);
    }

    @GetMapping("/contapagar")
    public List<ContaPagar> findAll() {
        return repository.findAll();
    }

    /*
    @GetMapping("/contapagar/{id}")
    public ResponseEntity<ContaPagar> getById(@PathVariable("codigo") Long codigo) {
        Optional<ContaPagar> c = repository.findById(codigo);

        if (c.isPresent()) {
            return ResponseEntity.ok(c.get());
        }
        return ResponseEntity.badRequest().build();
    }

     */
}
