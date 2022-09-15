package com.unimovimento.app.pessoaendereco;

import com.unimovimento.app.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class PessoaEnderecoDTO {

    private UUID id;

    @Size(min = 8, message = "CEP invalido.")
    private String cep;


    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private Pessoa pessoa;
}
