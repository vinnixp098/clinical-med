package com.vinicius.clinical_med_crud.business.Fotos;

import org.springframework.web.multipart.MultipartFile;

public record DadosCadastroFotos(
        String nomeArquivo,
        MultipartFile dados
) {}
