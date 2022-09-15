package com.unimovimento.app.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;


    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listaPessoas();
    }

    @PostMapping
    public ResponseEntity<Object> createPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) throws Exception {
        return pessoaService.save(pessoaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable("id") UUID id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.update(pessoaDTO, id);
    }

}
