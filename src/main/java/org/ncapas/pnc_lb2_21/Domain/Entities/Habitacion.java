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
@Table(name = "habitacion")

public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "habitacion_id")
    private UUID idHabitacion;

    @ManyToOne
    @JoinColumn(name = "piso", nullable = false)
    private Piso piso;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion", nullable = false)
    private Tipo_Habitacion tipoHabitacion;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;
}
