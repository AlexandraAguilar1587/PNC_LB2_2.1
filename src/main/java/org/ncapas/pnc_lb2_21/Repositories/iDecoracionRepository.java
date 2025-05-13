package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Decoracion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iDecoracionRepository extends iGenericRepository<Decoracion, UUID>{
    // 1) Métodos JPA derivados
    List<Decoracion> findByCodigo(String codigo);
    List<Decoracion> findByNombre(String nombre);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM decoracion WHERE codigo = :codigo", nativeQuery = true)
    List<Decoracion> findByCodigoNative(@Param("codigo") String codigo);

    @Query(value = "SELECT * FROM decoracion WHERE nombre = :nombre", nativeQuery = true)
    List<Decoracion> findByNombreNative(@Param("nombre") String nombre);

    // 3) Consultas JPQL
    @Query("SELECT d FROM Decoracion d WHERE d.codigo = :codigo")
    List<Decoracion> findByCodigoJpql(@Param("codigo") String codigo);

    @Query("SELECT d FROM Decoracion d WHERE d.nombre = :nombre")
    List<Decoracion> findByNombreJpql(@Param("nombre") String nombre);
}
