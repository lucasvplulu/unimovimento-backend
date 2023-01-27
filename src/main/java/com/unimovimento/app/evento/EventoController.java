package com.unimovimento.app.evento;

import com.unimovimento.app.util.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evento")
public class EventoController extends GenericController<Evento> {

    @Autowired
    public EventoController(@Qualifier("eventoService") EventoService eventoService) {
        super(eventoService);
    }

}
