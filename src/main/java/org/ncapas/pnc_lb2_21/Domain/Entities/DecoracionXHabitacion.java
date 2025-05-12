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
@Table(name = "decoracion_x_habitacion")

public class DecoracionXHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "decoracion_x_habitacion_id")
    private UUID idDecoracionXHabitacion;

    @ManyToOne
    @JoinColumn(name = "decoracion", nullable = false)
    private Decoracion decoracion;

    @ManyToOne
    @JoinColumn(name = "habitacion", nullable = false)
    private Habitacion habitacion;
}
