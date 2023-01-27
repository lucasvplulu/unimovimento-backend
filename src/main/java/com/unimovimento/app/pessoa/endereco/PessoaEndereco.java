package com.unimovimento.app.pessoa.endereco;

import com.unimovimento.app.pessoa.Pessoa;
import com.unimovimento.app.util.GenericEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoa_enderecos")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEndereco extends GenericEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(length = 8)
    private String cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ToString.Exclude
    private Pessoa pessoa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaEndereco that = (PessoaEndereco) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
