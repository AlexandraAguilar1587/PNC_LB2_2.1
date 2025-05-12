package org.ncapas.pnc_lb2_21.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idJornada;

    @Column
    private String codigo;

    @Column
    private String nombre;
}
