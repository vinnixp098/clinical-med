package com.vinicius.clinical_med_crud.business.Paciente;

import com.vinicius.clinical_med_crud.business.Endereco.Endereco;

public record DadosListagemPacientes(
  Long Id,
  String nome,
  String cpf,
  Endereco endereco,
  String email

) {
   public DadosListagemPacientes(Paciente paciente){
     this(
       paciente.getId(),
       paciente.getNome(),
       paciente.getCpf(),
       paciente.getEndereco(),
       paciente.getEmail()
     );


   }
}
