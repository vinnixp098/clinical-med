package com.vinicius.clinical_med_crud.business.Consulta;

import com.vinicius.clinical_med_crud.business.Endereco.Endereco;
import com.vinicius.clinical_med_crud.business.Medico.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Table(name= "consultas")
@Entity(name = "Consulta" )
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

  @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private String medico;
  private String paciente;
  private String cpfPaciente;
  private String telefonePaciente;
  private String telefoneMedico;
  private String crm;
  private LocalDate dataConsulta;
  private BigDecimal valor;

  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;

  @Embedded
  private Endereco endereco;

  public Consulta(DadosCadastroConsulta dados) {
    this.medico = dados.medico();
    this.paciente = dados.paciente();
    this.cpfPaciente = dados.cpfPaciente();
    this.telefoneMedico = dados.telefoneMedico();
    this.telefonePaciente = dados.telefonePaciente();
    this.crm = dados.crm();
    this.dataConsulta = dados.dataConsulta();
    this.valor = dados.valor();
    this.endereco = new Endereco(dados.endereco());
    this.especialidade = dados.especialidade();
  }


  public Consulta(Consulta consulta) {
    this.id = consulta.getId();
    this.medico = consulta.getMedico();
    this.paciente = consulta.getPaciente();
    this.cpfPaciente = consulta.getCpfPaciente();
    this.telefonePaciente = consulta.getTelefonePaciente();
    this.telefoneMedico = consulta.getTelefoneMedico();
    this.crm = consulta.getCrm();
    this.dataConsulta = consulta.getDataConsulta();
    this.valor = consulta.getValor();
    this.especialidade = consulta.getEspecialidade();
    this.endereco = consulta.getEndereco();
  }

    public void excluir(Long id) {

    }
}
