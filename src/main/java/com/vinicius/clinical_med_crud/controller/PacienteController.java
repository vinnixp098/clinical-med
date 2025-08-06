package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Medico.DadosListagemMedico;
import com.vinicius.clinical_med_crud.business.Paciente.DadosCadastroPaciente;
import com.vinicius.clinical_med_crud.business.Paciente.DadosListagemPacientes;
import com.vinicius.clinical_med_crud.business.Paciente.Paciente;
import com.vinicius.clinical_med_crud.business.Paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);
    }
}