package com.unimovimento.app.pessoa;

import com.unimovimento.app.util.enumeration.TipoEstadoCivil;
import com.unimovimento.app.util.enumeration.TipoGrauInstrucao;
import com.unimovimento.app.util.enumeration.TipoSexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    private LocalDate data_nasc;

    private TipoSexo sexo;
    private TipoEstadoCivil estadoCivil;

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

    public Pessoa(String cpf, String nome, LocalDate data_nasc, TipoSexo sexo, TipoEstadoCivil estadoCivil, String email, String celular, String rg, String rgEmissor, String foto, Boolean tomaRemedio, String remedio, Boolean alergia, String remedioAlergia, TipoGrauInstrucao escolaridade, String profissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.celular = celular;
        this.rg = rg;
        this.rgEmissor = rgEmissor;
        this.foto = foto;
        this.tomaRemedio = tomaRemedio;
        this.remedio = remedio;
        this.alergia = alergia;
        this.remedioAlergia = remedioAlergia;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
    }
}
