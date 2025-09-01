package com.vinicius.clinical_med_crud.business.Usuario;

import com.vinicius.clinical_med_crud.business.Endereco.Endereco;
import com.vinicius.clinical_med_crud.business.Paciente.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuarios")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private String crm;
    private String telefone;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Usuario(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

}