package com.unimovimento.app.formulario;

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
public class FormularioService implements GenericService<Formulario> {

    @Autowired
    private FormularioRepository formularioRepository;

    @Override
    public List<Formulario> findAll() {
        return formularioRepository.findAll();
    }

    @Transactional
    @Override
    public Formulario create(Formulario formulario) {
        try {
            return formularioRepository.saveAndFlush(formulario);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    @Override
    public Formulario update(UUID id, Formulario formulario) {

        Optional<Formulario> formularioData = formularioRepository.findById(id);

        if (formularioData.isPresent()) {
            return formularioRepository.save(formulario);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formulário não encontrada.");
        }
    }

    @Override
    public Formulario findById(UUID id) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }


}
