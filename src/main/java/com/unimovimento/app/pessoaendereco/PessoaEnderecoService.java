package com.unimovimento.app.pessoaendereco;

import com.unimovimento.app.pessoa.Pessoa;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaEnderecoService {

    public PessoaEndereco convertDto(Pessoa pessoa, PessoaEnderecoDTO pessoaEnderecoDTO) {
        return new PessoaEndereco (
                pessoaEnderecoDTO.getId() != null ? pessoaEnderecoDTO.getId() : UUID.randomUUID(),
                pessoaEnderecoDTO.getCep().replace(".", "").replace("-", ""),
                pessoaEnderecoDTO.getPais(),
                pessoaEnderecoDTO.getEstado(),
                pessoaEnderecoDTO.getCidade(),
                pessoaEnderecoDTO.getBairro(),
                pessoaEnderecoDTO.getLogradouro(),
                pessoaEnderecoDTO.getNumero(),
                pessoaEnderecoDTO.getComplemento(),
                pessoa
        );
    }

}
