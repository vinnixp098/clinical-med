package com.vinicius.clinical_med_crud.business.Medico;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank // nao permite que esteja em branco
        String nome,

        @NotBlank // nao permite que esteja em branco
        @Email // anotacao de validacao de formato do email
        String email,

        @NotNull
        String telefone,

        @NotBlank // nao permite que esteja em branco
        @Pattern(regexp = "\\d{4,6}") // expressão regular para so permitir 6 digitos
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco
) {

}
