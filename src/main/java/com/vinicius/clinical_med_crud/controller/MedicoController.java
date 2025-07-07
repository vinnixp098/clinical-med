package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Medico.MedicoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @PostMapping
    public void cadastrarMedico(@RequestBody MedicoDTO dadosMedico){
        System.out.println(dadosMedico);
    }
}
