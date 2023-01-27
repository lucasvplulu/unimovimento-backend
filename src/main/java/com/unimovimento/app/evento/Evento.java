package com.unimovimento.app.evento;

import com.unimovimento.app.util.GenericEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "eventos")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Column(nullable = false)
    private LocalDate dataInicio;
    @Column(nullable = false)
    private LocalDate dataFinal;
    private LocalDate dataFinalInscricao;
    private LocalDate dataFinalBoleto;

    public Evento(String nome, String descricao, LocalDate dataInicio, LocalDate dataFinal, LocalDate dataFinalInscricao, LocalDate dataFinalBoleto) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.dataFinalInscricao = dataFinalInscricao;
        this.dataFinalBoleto = dataFinalBoleto;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Evento evento = (Evento) o;
        return id.equals(evento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
