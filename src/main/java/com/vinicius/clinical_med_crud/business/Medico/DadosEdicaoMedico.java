package com.vinicius.clinical_med_crud.business.Medico;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;
import com.vinicius.clinical_med_crud.business.Endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {}
