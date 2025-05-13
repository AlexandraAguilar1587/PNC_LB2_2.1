package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Comprobante;
import org.ncapas.pnc_lb2_21.Domain.Entities.Reservacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface iComprobanteRepository extends iGenericRepository<Comprobante, UUID>{
    // 1)JPA
    List<Comprobante> findByFecha(LocalDate fecha);
    List<Comprobante> findByMontoCobro(BigDecimal montoCobro);
    List<Comprobante> findByReservacion(Reservacion reservacion);

    // 2) Nativas
    @Query(value = "SELECT * FROM comprobante WHERE fecha = :fecha", nativeQuery = true)
    List<Comprobante> findByFechaNative(@Param("fecha") LocalDate fecha);

    @Query(value = "SELECT * FROM comprobante WHERE monto_cobro = :montoCobro", nativeQuery = true)
    List<Comprobante> findByMontoCobroNative(@Param("montoCobro") BigDecimal montoCobro);

    @Query(value = "SELECT * FROM comprobante WHERE reservacion = :reservacionId", nativeQuery = true)
    List<Comprobante> findByReservacionNative(@Param("reservacionId") UUID reservacionId);

    // 3) JPQL
    @Query("SELECT c FROM Comprobante c WHERE c.fecha = :fecha")
    List<Comprobante> findByFechaJpql(@Param("fecha") LocalDate fecha);

    @Query("SELECT c FROM Comprobante c WHERE c.montoCobro = :montoCobro")
    List<Comprobante> findByMontoCobroJpql(@Param("montoCobro") BigDecimal montoCobro);

    @Query("SELECT c FROM Comprobante c WHERE c.reservacion.idReservacion = :reservacionId")
    List<Comprobante> findByReservacionJpql(@Param("reservacionId") UUID reservacionId);

}
