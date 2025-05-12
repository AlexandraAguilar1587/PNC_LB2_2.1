package org.ncapas.pnc_lb2_21.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cambio_Punto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCambio_punto;

    @ManyToOne
    @JoinColumn(name = "huesped_id", nullable = false)
    private Huesped huesped;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;


    @Column
    private int cantidadPuntos;

    @Column
    private LocalDateTime ultimaActualizacion;
}
