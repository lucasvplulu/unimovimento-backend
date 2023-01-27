package com.unimovimento.app.pessoa.emergencia;

import com.unimovimento.app.pessoa.Pessoa;
import com.unimovimento.app.pessoa.emergencia.contato.PessoaContatoEmergencia;
import com.unimovimento.app.util.GenericEntity;
import com.unimovimento.app.util.enumeration.TipoSanguineo;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoa_dados_emergencia")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEmergencia extends GenericEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false)
    private Boolean tomaRemedio;
    private String descricaoRemedio;
    @Column(nullable = false)
    private Boolean temAlergia;
    private String descricaoAlergia;
    private Boolean temPlanoSaude;
    private String descricaoPlanoSaude;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoSanguineo tipoSanguineo;
    private String observacoes;
    @OneToMany(mappedBy = "pessoaEmergencia", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<PessoaContatoEmergencia> contatoEmergencia = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ToString.Exclude
    private Pessoa pessoa;

    public PessoaEmergencia(Boolean tomaRemedio, String descricaoRemedio, Boolean temAlergia, String descricaoAlergia, Boolean temPlanoSaude, String descricaoPlanoSaude, TipoSanguineo tipoSanguineo, String observacoes) {
        this.tomaRemedio = tomaRemedio;
        this.descricaoRemedio = descricaoRemedio;
        this.temAlergia = temAlergia;
        this.descricaoAlergia = descricaoAlergia;
        this.temPlanoSaude = temPlanoSaude;
        this.descricaoPlanoSaude = descricaoPlanoSaude;
        this.tipoSanguineo = tipoSanguineo;
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaEmergencia that = (PessoaEmergencia) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
