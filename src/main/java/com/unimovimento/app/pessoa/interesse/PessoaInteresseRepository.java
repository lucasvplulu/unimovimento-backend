package com.unimovimento.app.pessoa.interesse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaInteresseRepository extends JpaRepository<PessoaInteresse, UUID> {

}
