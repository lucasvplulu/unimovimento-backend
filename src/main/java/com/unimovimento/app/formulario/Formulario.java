package com.unimovimento.app.formulario;

import com.sun.istack.NotNull;
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
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Formulario {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    @Size(min = 2, message = "O nome deve conter no minimo 2 caracteres.")
    @Column(nullable = false)
    private String descricao;

    @NotNull
    private LocalDate dt_evento;
    private LocalDate dt_final_inscricao;
    private LocalDate dt_final_boleto;

    public Formulario(String descricao, LocalDate dt_evento, LocalDate dt_final_inscricao, LocalDate dt_final_boleto) {
        this.descricao = descricao;
        this.dt_evento = dt_evento;
        this.dt_final_inscricao = dt_final_inscricao;
        this.dt_final_boleto = dt_final_boleto;
    }
}
