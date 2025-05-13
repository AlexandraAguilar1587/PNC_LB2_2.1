package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface iRoleRepository extends iGenericRepository<Rol, Integer> {
    // 1) Métodos JPA
    Rol findByCodigo(String codigo);
    Rol findByNombre(String nombre);

    // 2) Consultas nativas
    @Query(
            value = "SELECT * FROM rol WHERE codigo = :codigo",
            nativeQuery = true
    )
    Rol findByCodigoNative(@Param("codigo") String codigo);

    @Query(
            value = "SELECT * FROM rol WHERE nombre = :nombre",
            nativeQuery = true
    )
    Rol findByNombreNative(@Param("nombre") String nombre);

    // 3) Consultas JPQL
    @Query("SELECT r FROM Rol r WHERE r.codigo = :codigo")
    Rol findByCodigoJpql(@Param("codigo") String codigo);

    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    Rol findByNombreJpql(@Param("nombre") String nombre);

}
