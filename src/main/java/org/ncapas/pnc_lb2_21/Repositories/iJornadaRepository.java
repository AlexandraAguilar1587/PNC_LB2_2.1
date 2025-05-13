package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Jornada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iJornadaRepository extends iGenericRepository<Jornada,Long>{
    // 1) Métodos JPA
    List<Jornada> findByCodigo(String codigo);
    List<Jornada> findByNombre(String nombre);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM jornada WHERE codigo = :codigo", nativeQuery = true)
    List<Jornada> findByCodigoNative(@Param("codigo") String codigo);

    @Query(value = "SELECT * FROM jornada WHERE nombre = :nombre", nativeQuery = true)
    List<Jornada> findByNombreNative(@Param("nombre") String nombre);

    // 3) Consultas JPQL
    @Query("SELECT j FROM Jornada j WHERE j.codigo = :codigo")
    List<Jornada> findByCodigoJpql(@Param("codigo") String codigo);

    @Query("SELECT j FROM Jornada j WHERE j.nombre = :nombre")
    List<Jornada> findByNombreJpql(@Param("nombre") String nombre);
}
