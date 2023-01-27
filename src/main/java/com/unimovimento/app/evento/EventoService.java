package com.unimovimento.app.evento;

import com.unimovimento.app.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService implements GenericService<Evento> {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Transactional
    @Override
    public Evento create(Evento evento) {
        try {
            return eventoRepository.saveAndFlush(evento);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    @Override
    public Evento update(UUID id, Evento evento) {

        Optional<Evento> eventoData = eventoRepository.findById(id);

        if (eventoData.isPresent()) {
            return eventoRepository.save(evento);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Evento não encontrado.");
        }
    }

    @Override
    public Evento findById(UUID id) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }


}
