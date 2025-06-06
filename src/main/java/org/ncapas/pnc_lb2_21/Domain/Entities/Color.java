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
@Table(name = "color_boton")


public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "color_boton_id")
    private UUID idColor;

    @Column(nullable = false, length = 10)
    private String codigo;

    @Column(nullable = false, length = 50)
    private String nombre;
}
