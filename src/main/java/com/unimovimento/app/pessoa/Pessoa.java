package com.unimovimento.app.pessoa;

import com.unimovimento.app.pessoa.conhecimento.PessoaConhecimento;
import com.unimovimento.app.pessoa.contato.PessoaContato;
import com.unimovimento.app.pessoa.curiosidade.PessoaCuriosidade;
import com.unimovimento.app.pessoa.documento.PessoaDocumento;
import com.unimovimento.app.pessoa.emergencia.PessoaEmergencia;
import com.unimovimento.app.pessoa.endereco.PessoaEndereco;
import com.unimovimento.app.pessoa.interesse.PessoaInteresse;
import com.unimovimento.app.pessoa.ministerio.PessoaMinisterio;
import com.unimovimento.app.util.GenericEntity;
import com.unimovimento.app.util.enumeration.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoas")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false)
    private String nome;
    private LocalDate dataNascimento;
    @Enumerated(value = EnumType.STRING)
    private TipoSexo sexo;
    @Enumerated(value = EnumType.STRING)
    private TipoEstadoCivil estadoCivil;
    private String nomeConjuge;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PessoaDocumento documento;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PessoaContato contato;
    private String foto;
    @Enumerated(value = EnumType.STRING)
    private TipoGrauInstrucao escolaridade;
    private String profissao;
    @Enumerated(value = EnumType.STRING)
    private TamanhoCamisa tamanhoCamisa;
    @Enumerated(value = EnumType.STRING)
    private TipoCamisa tipoCamisa;
    @Enumerated(value = EnumType.STRING)
    private TipoVozCoral tipoVozCoral;
    @Transient
    private PessoaEndereco endereco;
    @Transient
    @Setter(value = AccessLevel.NONE)
    private List<PessoaConhecimento> conhecimentos = new ArrayList<>();
    @Transient
    @Setter(value = AccessLevel.NONE)
    private List<PessoaInteresse> interesses = new ArrayList<>();
    @Transient
    private PessoaMinisterio dadoMinisterial;
    @Transient
    private PessoaCuriosidade curiosidade;
    @Transient
    private PessoaEmergencia dadoEmergencial;

    public Pessoa(String nome, LocalDate dataNascimento, TipoSexo sexo, TipoEstadoCivil estadoCivil, String nomeConjuge, String foto, TipoGrauInstrucao escolaridade, String profissao, TamanhoCamisa tamanhoCamisa, TipoCamisa tipoCamisa, TipoVozCoral tipoVozCoral) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nomeConjuge = nomeConjuge;
        this.foto = foto;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.tamanhoCamisa = tamanhoCamisa;
        this.tipoCamisa = tipoCamisa;
        this.tipoVozCoral = tipoVozCoral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
