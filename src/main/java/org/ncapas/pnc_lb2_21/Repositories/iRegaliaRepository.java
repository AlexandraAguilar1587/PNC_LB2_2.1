package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Regalia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iRegaliaRepository extends iGenericRepository<Regalia, UUID>{

    // 1) Métodos JPA derivados
    List<Regalia> findByNombre(String nombre);
    List<Regalia> findByDescripcion(String descripcion);
    List<Regalia> findByPuntosCoste(int puntosCoste);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM regalia WHERE nombre = :nombre", nativeQuery = true)
    List<Regalia> findByNombreNative(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM regalia WHERE descripcion = :descripcion", nativeQuery = true)
    List<Regalia> findByDescripcionNative(@Param("descripcion") String descripcion);

    @Query(value = "SELECT * FROM regalia WHERE puntos_coste = :puntosCoste", nativeQuery = true)
    List<Regalia> findByPuntosCosteNative(@Param("puntosCoste") int puntosCoste);

    // 3) Consultas JPQL
    @Query("SELECT r FROM Regalia r WHERE r.nombre = :nombre")
    List<Regalia> findByNombreJpql(@Param("nombre") String nombre);

    @Query("SELECT r FROM Regalia r WHERE r.descripcion = :descripcion")
    List<Regalia> findByDescripcionJpql(@Param("descripcion") String descripcion);

    @Query("SELECT r FROM Regalia r WHERE r.puntosCoste = :puntosCoste")
    List<Regalia> findByPuntosCosteJpql(@Param("puntosCoste") int puntosCoste);
}
