package com.unimovimento.app.pessoa.conhecimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaConhecimentoRepository extends JpaRepository<PessoaConhecimento, UUID> {

}
