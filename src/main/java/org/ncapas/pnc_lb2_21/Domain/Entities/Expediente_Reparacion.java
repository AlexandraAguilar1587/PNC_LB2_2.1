package org.ncapas.pnc_lb2_21.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expediente_reparacion")

public class Expediente_Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expediente_reparacion_id")
    private UUID idExpediente;

    @ManyToOne
    @JoinColumn(name = "habitacion", nullable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "empleado", nullable = false)
    private Empleado empleado;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(name = "descripcion_reparacion", length = 500)
    private String descripcionReparacion;
}
