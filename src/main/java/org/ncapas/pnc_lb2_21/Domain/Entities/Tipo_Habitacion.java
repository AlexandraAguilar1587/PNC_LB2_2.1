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
@Table(name = "tipo_habitacion")
public class Tipo_Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipo_habitacion_id")
    private UUID idTipoHabitacion;

    @Column(nullable = false, length = 10)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;
}
