package com.unimovimento.app.pessoa;

import com.unimovimento.app.pessoaendereco.PessoaEnderecoRepository;
import com.unimovimento.app.pessoaendereco.PessoaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    @Autowired
    private PessoaEnderecoService pessoaEnderecoService;


    public List<Pessoa> listaPessoas() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Object> save(PessoaDTO pessoaDTO) throws Exception {
        try {

            Pessoa pessoa = new Pessoa(
                    pessoaDTO.getCpf().replace(".", "").replace("-", ""),
                    pessoaDTO.getNome(),
                    pessoaDTO.getData_nasc(),
                    pessoaDTO.getSexo(),
                    pessoaDTO.getEstadoCivil(),
                    pessoaDTO.getEmail(),
                    pessoaDTO.getCelular(),
                    pessoaDTO.getRg(),
                    pessoaDTO.getRgEmissor(),
                    pessoaDTO.getFoto(),
                    pessoaDTO.getTomaRemedio(),
                    pessoaDTO.getRemedio(),
                    pessoaDTO.getAlergia(),
                    pessoaDTO.getRemedioAlergia(),
                    pessoaDTO.getEscolaridade(),
                    pessoaDTO.getProfissao()
            );

            pessoa = pessoaRepository.saveAndFlush(pessoa);

            var endereco = pessoaEnderecoService.convertDto(pessoa, pessoaDTO.getPessoaEndereco());
            pessoaEnderecoRepository.save(endereco);

            return ResponseEntity.accepted().body(pessoa);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public ResponseEntity<Object> update(PessoaDTO pessoaDTO, UUID id) {

        Optional<Pessoa> pessoaData = pessoaRepository.findById(id);

        if (pessoaData.isPresent()) {
            Pessoa pessoa = pessoaData.get();
            pessoa.setAlergia(pessoaDTO.getAlergia());
            pessoa.setCelular(pessoaDTO.getCelular());
            pessoa.setCpf(pessoaDTO.getCpf()
                    .replace(".", "")
                    .replace("-", "")
            );
            pessoa.setData_nasc(pessoaDTO.getData_nasc());
            pessoa.setEmail(pessoaDTO.getEmail());
            pessoa.setEscolaridade(pessoaDTO.getEscolaridade());
            pessoa.setEstadoCivil(pessoaDTO.getEstadoCivil());
            pessoa.setFoto(pessoaDTO.getFoto());
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setProfissao(pessoaDTO.getProfissao());
            pessoa.setRemedio(pessoaDTO.getRemedio());
            pessoa.setRemedioAlergia(pessoaDTO.getRemedioAlergia());
            pessoa.setRg(pessoaDTO.getRg());
            pessoa.setRgEmissor(pessoaDTO.getRgEmissor());
            pessoa.setSexo(pessoaDTO.getSexo());
            pessoa.setTomaRemedio(pessoaDTO.getTomaRemedio());

            pessoa = pessoaRepository.save(pessoa);
            return ResponseEntity.accepted().body(pessoa);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
