package com.unimovimento.app.util;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericEntity {

    @CreatedBy
    @Column(nullable = false)
    private String autorCriacao;
    @LastModifiedBy
    @Column(nullable = false)
    private String autorModificacao;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime dataModificacao;

}
