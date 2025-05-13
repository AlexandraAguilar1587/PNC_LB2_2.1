package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Tipo_Habitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iTipoHabitacionRepository extends iGenericRepository<Tipo_Habitacion, UUID> {
    // 1) Métodos JPA derivados
    List<Tipo_Habitacion> findByCodigo(String codigo);
    List<Tipo_Habitacion> findByNombre(String nombre);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM tipo_habitacion WHERE codigo = :codigo", nativeQuery = true)
    List<Tipo_Habitacion> findByCodigoNative(@Param("codigo") String codigo);

    @Query(value = "SELECT * FROM tipo_habitacion WHERE nombre = :nombre", nativeQuery = true)
    List<Tipo_Habitacion> findByNombreNative(@Param("nombre") String nombre);

    // 3) Consultas JPQL
    @Query("SELECT t FROM Tipo_Habitacion t WHERE t.codigo = :codigo")
    List<Tipo_Habitacion> findByCodigoJpql(@Param("codigo") String codigo);

    @Query("SELECT t FROM Tipo_Habitacion t WHERE t.nombre = :nombre")
    List<Tipo_Habitacion> findByNombreJpql(@Param("nombre") String nombre);

}
