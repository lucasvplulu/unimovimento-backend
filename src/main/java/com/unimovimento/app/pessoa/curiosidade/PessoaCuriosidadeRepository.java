package com.unimovimento.app.pessoa.curiosidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaCuriosidadeRepository extends JpaRepository<PessoaCuriosidade, UUID> {

}
