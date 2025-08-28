package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Consulta.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> CadastrarConsulta(@RequestBody DadosCadastroConsulta dados){
      var consultaExistente = repository.findByDataConsultaAndCrm(dados.dataConsulta(), dados.crm());

      if(consultaExistente.isEmpty()){
          repository.save(new Consulta(dados));
          return ResponseEntity.ok().body("Consulta marcada com sucesso!");
      } else{
          return ResponseEntity.ok().body("Já existe uma consulta marcada para a data selecionada!");
      }
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
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> deletarMedico(@PathVariable Long id){
      var consultaExistente = repository.findById(id);
      if(consultaExistente.isPresent()){
          repository.deleteById(id);
          return ResponseEntity.ok().body("Consulta deletada com sucesso!");
      } else{
          return ResponseEntity.notFound().build();
      }

  }
}
