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
@Table(name = "reservacion")
public class Reservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "reservacion_id")
    private UUID idReservacion;

    @ManyToOne
    @JoinColumn(name = "huesped", nullable = false)
    private Huesped huesped;

    @ManyToOne
    @JoinColumn(name = "habitacion", nullable = false)
    private Habitacion habitacion;

    @Column(name = "hora_entrada", nullable = false)
    private LocalDateTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private LocalDateTime horaSalida;

    @Column(nullable = false, length = 20)
    private String estado;
}
