package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Empleado;
import org.ncapas.pnc_lb2_21.Domain.Entities.Jornada;
import org.ncapas.pnc_lb2_21.Domain.Entities.Piso;
import org.ncapas.pnc_lb2_21.Domain.Entities.Rotacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iRotacionRepository extends iGenericRepository<Rotacion, UUID>{

    // 1) Métodos JPA
    List<Rotacion> findByEmpleado(Empleado empleado);
    List<Rotacion> findByJornada(Jornada jornada);
    List<Rotacion> findByPiso(Piso piso);
    List<Rotacion> findByMesAndAnio(Integer mes, Integer anio);
    List<Rotacion> findByEstado(String estado);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM rotacion WHERE empleado_id = :empleadoId", nativeQuery = true)
    List<Rotacion> findByEmpleadoNative(@Param("empleadoId") UUID empleadoId);

    @Query(value = "SELECT * FROM rotacion WHERE jornada_id = :jornadaId", nativeQuery = true)
    List<Rotacion> findByJornadaNative(@Param("jornadaId") UUID jornadaId);

    @Query(value = "SELECT * FROM rotacion WHERE piso_id = :pisoId", nativeQuery = true)
    List<Rotacion> findByPisoNative(@Param("pisoId") UUID pisoId);

    @Query(value = "SELECT * FROM rotacion WHERE mes = :mes AND anio = :anio", nativeQuery = true)
    List<Rotacion> findByMesAnioNative(@Param("mes") Integer mes, @Param("anio") Integer anio);

    @Query(value = "SELECT * FROM rotacion WHERE estado = :estado", nativeQuery = true)
    List<Rotacion> findByEstadoNative(@Param("estado") String estado);

    // 3) Consultas JPQL
    @Query("SELECT r FROM Rotacion r WHERE r.empleado = :empleado")
    List<Rotacion> findByEmpleadoJpql(@Param("empleado") Empleado empleado);

    @Query("SELECT r FROM Rotacion r WHERE r.jornada = :jornada")
    List<Rotacion> findByJornadaJpql(@Param("jornada") Jornada jornada);

    @Query("SELECT r FROM Rotacion r WHERE r.piso = :piso")
    List<Rotacion> findByPisoJpql(@Param("piso") Piso piso);

    @Query("SELECT r FROM Rotacion r WHERE r.mes = :mes AND r.anio = :anio")
    List<Rotacion> findByMesAndAnioJpql(@Param("mes") Integer mes, @Param("anio") Integer anio);

    @Query("SELECT r FROM Rotacion r WHERE r.estado = :estado")
    List<Rotacion> findByEstadoJpql(@Param("estado") String estado);
}
