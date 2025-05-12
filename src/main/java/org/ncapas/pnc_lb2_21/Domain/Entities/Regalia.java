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
public class Regalia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRegalia;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private int puntosCoste;

}
