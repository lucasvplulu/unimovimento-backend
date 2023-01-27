package com.unimovimento.app.pessoa.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaContatoRepository extends JpaRepository<PessoaContato, UUID> {

}
