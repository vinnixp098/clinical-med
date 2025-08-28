package com.vinicius.clinical_med_crud.business.Consulta;

import com.vinicius.clinical_med_crud.business.Endereco.DadosEndereco;
import com.vinicius.clinical_med_crud.business.Medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroConsulta(
  @NotBlank // nao permite que esteja em branco
  String medico,

  @NotBlank // nao permite que esteja em branco
  String paciente,


  @NotBlank // nao permite que esteja em branco
  String telefoneMedico,

  @NotBlank // nao permite que esteja em branco
  String telefonePaciente,

  @NotNull // nao permite que esteja em branco
  LocalDate dataConsulta,

  @NotNull // nao permite que esteja em branco
  BigDecimal valor,


  @NotBlank // nao permite que esteja em branco
  @Pattern(regexp = "\\d{4,6}") // expressão regular para so permitir 6 digitos
  String crm,

  @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpfPaciente,

  @NotNull
  Especialidade especialidade,

  @NotNull
  @Valid
  DadosEndereco endereco
) {

}
