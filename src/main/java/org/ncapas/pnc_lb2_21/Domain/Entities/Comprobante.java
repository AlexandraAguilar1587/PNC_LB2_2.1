package org.ncapas.pnc_lb2_21.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comprobante")

public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comprobante_id")
    private UUID idComprobante;

    @ManyToOne
    @JoinColumn(name = "reservacion", nullable = false)
    private Reservacion reservacion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "monto_cobro", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoCobro;
}
