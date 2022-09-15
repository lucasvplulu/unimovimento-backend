package com.unimovimento.app.pessoa;

import com.sun.istack.NotNull;
import com.unimovimento.app.pessoaendereco.PessoaEnderecoDTO;
import com.unimovimento.app.util.enumeration.TipoEstadoCivil;
import com.unimovimento.app.util.enumeration.TipoGrauInstrucao;
import com.unimovimento.app.util.enumeration.TipoSexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class PessoaDTO {

    private UUID id;

    @NotNull
    @Size(min = 11, message = "CPF invalido.")
    private String cpf;


    @NotNull
    @Size(min = 2, message = "O nome deve conter no minimo 2 caracteres.")
    private String nome;

    private LocalDate data_nasc;

    private TipoSexo sexo;
    private TipoEstadoCivil estadoCivil;

    @Email(regexp = ".+[@].+[\\.].+")
    private String email;

    private String celular;
    private String rg;
    private String rgEmissor;
    private String foto;
    private Boolean tomaRemedio;
    private String remedio;
    private Boolean alergia;
    private String remedioAlergia;
    private TipoGrauInstrucao escolaridade;
    private String profissao;
    private PessoaEnderecoDTO pessoaEndereco;
}
