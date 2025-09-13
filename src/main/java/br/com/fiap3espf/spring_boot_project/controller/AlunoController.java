package br.com.fiap3espf.spring_boot_project.controller;

import br.com.fiap3espf.spring_boot_project.aluno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public ResponseEntity<DadosListagemAluno> cadastrar(@RequestBody @Validated DadosCadastroAluno dados) {
        Aluno aluno = new Aluno();
        aluno.setNome(dados.nome());
        aluno.setEmail(dados.email());
        aluno.setTelefone(dados.telefone());
        aluno.setCpf(dados.cpf());
        aluno.setEndereco(dados.endereco().toEndereco());
        repository.save(aluno);
        return ResponseEntity.ok(new DadosListagemAluno(aluno));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        return repository.findAll(pageable).map(DadosListagemAluno::new);
    }
}
