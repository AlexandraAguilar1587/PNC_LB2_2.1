package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Color;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iColorRepository extends iGenericRepository<Color, UUID> {
    List<Color> findByCodigo(String codigo);
    List<Color> findByNombre(String nombre);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM color_boton WHERE codigo = :codigo", nativeQuery = true)
    List<Color> findByCodigoNative(@Param("codigo") String codigo);

    @Query(value = "SELECT * FROM color_boton WHERE nombre = :nombre", nativeQuery = true)
    List<Color> findByNombreNative(@Param("nombre") String nombre);

    // 3) Consultas JPQL
    @Query("SELECT c FROM Color c WHERE c.codigo = :codigo")
    List<Color> findByCodigoJpql(@Param("codigo") String codigo);

    @Query("SELECT c FROM Color c WHERE c.nombre = :nombre")
    List<Color> findByNombreJpql(@Param("nombre") String nombre);
}
