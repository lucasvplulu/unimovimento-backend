package com.unimovimento.app.pessoa.interesse;

import com.unimovimento.app.pessoa.Pessoa;
import com.unimovimento.app.util.GenericEntity;
import com.unimovimento.app.util.enumeration.TipoInteresse;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoa_interesses")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaInteresse extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Enumerated(value = EnumType.STRING)
    private TipoInteresse interesse;
    private String descricaoOutroInteresse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ToString.Exclude
    private Pessoa pessoa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaInteresse that = (PessoaInteresse) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
