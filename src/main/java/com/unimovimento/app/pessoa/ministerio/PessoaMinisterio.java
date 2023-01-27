package com.unimovimento.app.pessoa.ministerio;

import com.unimovimento.app.pessoa.Pessoa;
import com.unimovimento.app.util.GenericEntity;
import com.unimovimento.app.util.enumeration.TipoFuncaoEclesiastica;
import com.unimovimento.app.util.enumeration.TipoFuncaoJuventude;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoa_dados_ministeriais")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaMinisterio extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false)
    private String vocacao;
    private String descricaoVocacao;
    @Column(nullable = false)
    private String congregacao; //TODO: Alterar o tipo de String para uma classe de entidade Congregacao.
    @Column(nullable = false)
    private Boolean batizado;
    private LocalDate dataBatismo;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TipoFuncaoJuventude funcaoMinisterioJovens;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TipoFuncaoEclesiastica funcaoEclesiastica;
    @Column(nullable = false)
    private Boolean origemOutraDenominacao;
    private String nomeOutraDenominacao;
    @Column(nullable = false)
    private Boolean leuTodaBiblia;
    @Column(nullable = false)
    private Boolean formacaoTeologica;
    private String descricaoFormacaoTeologica;
    private String biografia;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ToString.Exclude
    private Pessoa pessoa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaMinisterio that = (PessoaMinisterio) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
