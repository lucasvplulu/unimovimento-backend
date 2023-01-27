package com.unimovimento.app.pessoa;

import com.unimovimento.app.util.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController extends GenericController<Pessoa> {

    @Autowired
    public PessoaController(@Qualifier("pessoaService") PessoaService pessoaService){
        super(pessoaService);
    }

}
