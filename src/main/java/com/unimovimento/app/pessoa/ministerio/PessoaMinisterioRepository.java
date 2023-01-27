package com.unimovimento.app.pessoa.ministerio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaMinisterioRepository extends JpaRepository<PessoaMinisterio, UUID> {

}
