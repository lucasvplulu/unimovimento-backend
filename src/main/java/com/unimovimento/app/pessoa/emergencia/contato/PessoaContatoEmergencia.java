package com.unimovimento.app.pessoa.emergencia.contato;

import com.unimovimento.app.pessoa.emergencia.PessoaEmergencia;
import com.unimovimento.app.util.GenericEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoa_contatos_emergencia")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaContatoEmergencia extends GenericEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "nome")
    private String nomeContatoEmergencia;
    @Column(name = "celular")
    private String celularContatoEmergencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emergencia_id", referencedColumnName = "id")
    @ToString.Exclude
    private PessoaEmergencia pessoaEmergencia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaContatoEmergencia that = (PessoaContatoEmergencia) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
