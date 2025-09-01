package com.vinicius.clinical_med_crud.controller;

import com.vinicius.clinical_med_crud.business.Fotos.DadosCadastroFotos;
import com.vinicius.clinical_med_crud.business.Fotos.Fotos;
import com.vinicius.clinical_med_crud.business.Fotos.FotosRepository;
import com.vinicius.clinical_med_crud.business.Medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "http://127.0.0.1:5500") // permite o frontend

public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    private FotosRepository fotosRepository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort= {"nome"}) Pageable paginacao){
        // o @pageableDefault serve para padronizar valores de ordenação e paginacao
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosEdicaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir(id);
    }

    @PostMapping
    @Transactional
    @RequestMapping("/upload-fotos")
    public ResponseEntity<?> uploadFotos(
            @RequestParam("nomeArquivo") String nomeArquivo,
            @RequestParam("arquivo") MultipartFile[] arquivos
    ) {
        try {
            for (MultipartFile arquivo : arquivos) {
                Fotos foto = new Fotos();
                foto.setNomeArquivo(nomeArquivo); // ou arquivo.getOriginalFilename()
                foto.setDados(arquivo.getBytes()); // converte em byte[] para salvar no DB

                // aqui você chamaria o repositório para salvar
                 fotosRepository.save(foto);
            }
            return ResponseEntity.ok().body("Upload concluído!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao fazer upload!");
        }
    }

    @GetMapping
    @RequestMapping("/list-fotos")
    public List<Fotos> listarFotos(){
        return fotosRepository.findAll();
    }

}
