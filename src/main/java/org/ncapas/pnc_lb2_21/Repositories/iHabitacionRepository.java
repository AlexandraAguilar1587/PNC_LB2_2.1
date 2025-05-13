package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Habitacion;
import org.ncapas.pnc_lb2_21.Domain.Entities.Piso;
import org.ncapas.pnc_lb2_21.Domain.Entities.Tipo_Habitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iHabitacionRepository extends iGenericRepository<Habitacion, UUID>{
    // 1) Métodos JPA
    List<Habitacion> findByNombre(String nombre);
    List<Habitacion> findByCapacidad(int capacidad);
    List<Habitacion> findByPiso(Piso piso);
    List<Habitacion> findByTipoHabitacion(Tipo_Habitacion tipoHabitacion);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM habitacion WHERE nombre = :nombre", nativeQuery = true)
    List<Habitacion> findByNombreNative(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM habitacion WHERE capacidad = :capacidad", nativeQuery = true)
    List<Habitacion> findByCapacidadNative(@Param("capacidad") int capacidad);

    @Query(value = "SELECT * FROM habitacion WHERE piso = :pisoId", nativeQuery = true)
    List<Habitacion> findByPisoNative(@Param("pisoId") UUID pisoId);

    @Query(value = "SELECT * FROM habitacion WHERE tipo_habitacion = :tipoId", nativeQuery = true)
    List<Habitacion> findByTipoHabitacionNative(@Param("tipoId") UUID tipoId);

    // 3) Consultas JPQL
    @Query("SELECT h FROM Habitacion h WHERE h.nombre = :nombre")
    List<Habitacion> findByNombreJpql(@Param("nombre") String nombre);

    @Query("SELECT h FROM Habitacion h WHERE h.capacidad = :capacidad")
    List<Habitacion> findByCapacidadJpql(@Param("capacidad") int capacidad);

    @Query("SELECT h FROM Habitacion h WHERE h.piso = :piso")
    List<Habitacion> findByPisoJpql(@Param("piso") Piso piso);

    @Query("SELECT h FROM Habitacion h WHERE h.tipoHabitacion = :tipo")
    List<Habitacion> findByTipoHabitacionJpql(@Param("tipo") Tipo_Habitacion tipo);
}
