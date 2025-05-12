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


@Table(name = "decoracion")

public class Decoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "decoracion_id")
    private UUID idDecoracion;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;
}
