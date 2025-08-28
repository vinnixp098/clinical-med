package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Consulta.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")

public class ConsultaController {

  @Autowired
  private ConsultaRepository repository;

  @PostMapping
  @Transactional
  public void CadastrarConsulta(@RequestBody @Valid DadosCadastroConsulta dados){
    repository.save(new Consulta(dados));
  }

  @GetMapping
  public List<Consulta> listarMedicos(){
    // o @pageableDefault serve para padronizar valores de ordenação e paginacao
    return repository.findAll();
  }

//  @PutMapping
//  @Transactional
//  public void atualizarMedico(@RequestBody @Valid DadosEdicaoMedico dados){
//    var medico = repository.getReferenceById(dados.id());
//    medico.atualizarDados(dados);
//  }
//
//  @DeleteMapping("/{id}")
//  @Transactional
//  public void deletarMedico(@PathVariable Long id){
//    var medico = repository.getReferenceById(id);
//    medico.excluir(id);
//  }
}
