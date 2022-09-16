package com.unimovimento.app.formulario;

import com.unimovimento.app.util.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController extends GenericController<Formulario> {

    @Autowired
    public FormularioController(@Qualifier("formularioController") FormularioService formularioService) {
        super(formularioService);
    }

}
