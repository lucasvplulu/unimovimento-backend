package com.unimovimento.app.formulario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, UUID> {

    Boolean existsByCpf(String cpf);

}
