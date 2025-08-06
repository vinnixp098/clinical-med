package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Medico.DadosListagemMedico;
import com.vinicius.clinical_med_crud.business.Medico.Medico;
import com.vinicius.clinical_med_crud.business.Medico.DadosCadastroMedico;
import com.vinicius.clinical_med_crud.business.Medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort= {"nome"}) Pageable paginacao){
        // o @pageableDefault serve para padronizar valores de ordenação e paginacao
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
