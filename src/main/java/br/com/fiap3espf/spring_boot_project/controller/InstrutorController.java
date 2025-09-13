package br.com.fiap3espf.spring_boot_project.controller;

import br.com.fiap3espf.spring_boot_project.instrutor.DadosCadastroInstrutor;
import br.com.fiap3espf.spring_boot_project.instrutor.DadosListagemInstrutor;
import br.com.fiap3espf.spring_boot_project.instrutor.Instrutor;
import br.com.fiap3espf.spring_boot_project.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        //System.out.println(dados);
        repository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listarInstrutores(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        return repository.findAll(pageable).map(DadosListagemInstrutor::new);
    }
}