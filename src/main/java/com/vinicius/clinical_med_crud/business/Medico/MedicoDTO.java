package com.vinicius.clinical_med_crud.business.Medico;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;

public record MedicoDTO(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
