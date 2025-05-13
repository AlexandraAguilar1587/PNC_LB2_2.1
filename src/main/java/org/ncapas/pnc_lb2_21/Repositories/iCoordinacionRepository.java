package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Coordinacion;
import org.ncapas.pnc_lb2_21.Domain.Entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iCoordinacionRepository extends iGenericRepository<Coordinacion, UUID>{

    // 1) Métodos JPA derivados
    List<Coordinacion> findByCoordinador(Empleado coordinador);
    List<Coordinacion> findByEmpleado(Empleado empleado);
    List<Coordinacion> findByEstado(Boolean estado);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM coordinacion WHERE coordinador_id = :coordinadorId", nativeQuery = true)
    List<Coordinacion> findByCoordinadorNative(@Param("coordinadorId") UUID coordinadorId);

    @Query(value = "SELECT * FROM coordinacion WHERE empleado_id = :empleadoId", nativeQuery = true)
    List<Coordinacion> findByEmpleadoNative(@Param("empleadoId") UUID empleadoId);

    @Query(value = "SELECT * FROM coordinacion WHERE estado = :estado", nativeQuery = true)
    List<Coordinacion> findByEstadoNative(@Param("estado") Boolean estado);

    // 3) Consultas JPQL
    @Query("SELECT c FROM Coordinacion c WHERE c.coordinador = :coordinador")
    List<Coordinacion> findByCoordinadorJpql(@Param("coordinador") Empleado coordinador);

    @Query("SELECT c FROM Coordinacion c WHERE c.empleado = :empleado")
    List<Coordinacion> findByEmpleadoJpql(@Param("empleado") Empleado empleado);

    @Query("SELECT c FROM Coordinacion c WHERE c.estado = :estado")
    List<Coordinacion> findByEstadoJpql(@Param("estado") Boolean estado);
}
