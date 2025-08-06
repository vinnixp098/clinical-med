package com.vinicius.clinical_med_crud.business.Medico;

public record DadosListagemMedico(
        Long Id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade

) {
    public DadosListagemMedico(Medico dados){
        this(
            dados.getId(),
            dados.getNome(),
            dados.getEmail(),
            dados.getCrm(),
            dados.getEspecialidade()
        );
    }
}
