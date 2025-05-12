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
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idDepartamento;

    @Column
    private String codigoDepartamento;

    @Column
    private String nombreDepartamento;
}
