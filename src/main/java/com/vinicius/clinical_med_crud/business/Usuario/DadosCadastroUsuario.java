package com.vinicius.clinical_med_crud.business.Usuario;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroUsuario(
        @NotBlank String nome,
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull @Valid DadosEndereco endereco
) {
}