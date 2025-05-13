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


public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idSucursal;

    @Column
    private String nombreSucursal;

    @Column
    private String direccionSucursal;

   /*
   @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;
   */


}
