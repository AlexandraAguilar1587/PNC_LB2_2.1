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
    @Table(name = "piso")
    public class Piso {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "piso_id")
        private UUID idPiso;

        @ManyToOne
        @JoinColumn(name = "color_boton", nullable = false)
        private Color colorBoton;

        @ManyToOne
        @JoinColumn(name = "sucursal", nullable = false)
        private Sucursal sucursal;

        @Column(nullable = false, length = 100)
        private String nombre;
    }
