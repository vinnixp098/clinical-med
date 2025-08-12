package com.vinicius.clinical_med_crud.business.Paciente;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}