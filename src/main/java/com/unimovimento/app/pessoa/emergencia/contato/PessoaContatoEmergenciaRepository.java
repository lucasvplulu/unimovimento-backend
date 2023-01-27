package com.unimovimento.app.pessoa.emergencia.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaContatoEmergenciaRepository extends JpaRepository<PessoaContatoEmergencia, UUID> {

}
