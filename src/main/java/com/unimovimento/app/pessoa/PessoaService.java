package com.unimovimento.app.pessoa;

import com.unimovimento.app.pessoa.endereco.PessoaEnderecoRepository;
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
public class PessoaService implements GenericService <Pessoa> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Transactional
    @Override
    public Pessoa create(Pessoa pessoa) {

            var cpf = pessoa.getDocumento().getCpf().replace(".", "").replace("-", "");
            if (pessoaRepository.existsByDocumentoCpf(cpf)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma pessoa cadastrada com este CPF.");
            }

        try {
            pessoa = pessoaRepository.saveAndFlush(pessoa);
            pessoaEnderecoRepository.save(pessoa.getEndereco());

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Transactional
    @Override
    public Pessoa update(UUID id, Pessoa pessoa) {

        Optional<Pessoa> pessoaData = pessoaRepository.findById(id);

        if (pessoaData.isPresent()) {
            return pessoaRepository.save(pessoa);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada.");
        }
    }

    @Override
    public Pessoa findById(UUID id) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
