package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Endereco.Endereco;
import com.vinicius.clinical_med_crud.business.Medico.Medico;
import com.vinicius.clinical_med_crud.business.Medico.MedicoDTO;
import com.vinicius.clinical_med_crud.business.Medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrarMedico(@RequestBody MedicoDTO dados){
        repository.save(new Medico(dados));
    }
}
