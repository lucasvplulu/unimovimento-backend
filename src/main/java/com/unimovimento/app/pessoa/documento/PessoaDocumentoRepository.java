package com.unimovimento.app.pessoa.documento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaDocumentoRepository extends JpaRepository<PessoaDocumento, UUID> {

}
