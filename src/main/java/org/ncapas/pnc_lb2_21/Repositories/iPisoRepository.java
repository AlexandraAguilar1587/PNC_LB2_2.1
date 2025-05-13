package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Color;
import org.ncapas.pnc_lb2_21.Domain.Entities.Piso;
import org.ncapas.pnc_lb2_21.Domain.Entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iPisoRepository extends iGenericRepository<Piso, UUID>{

    // 1) Métodos JPA
   List<Piso> findByNombre(String nombre);
   List<Piso> findByColorBoton(Color colorBoton);
    List<Piso> findBySucursal(Sucursal sucursal);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM piso WHERE nombre = :nombre", nativeQuery = true)
    List<Piso> findByNombreNative(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM piso WHERE color_boton = :colorBotonId", nativeQuery = true)
    List<Piso> findByColorBotonNative(@Param("colorBotonId") UUID colorBotonId);

    @Query(value = "SELECT * FROM piso WHERE sucursal = :sucursalId", nativeQuery = true)
    List<Piso> findBySucursalNative(@Param("sucursalId") UUID sucursalId);

    // 3) Consultas JPQL
    @Query("SELECT p FROM Piso p WHERE p.nombre = :nombre")
    List<Piso> findByNombreJpql(@Param("nombre") String nombre);

    @Query("SELECT p FROM Piso p WHERE p.colorBoton = :colorBoton")
    List<Piso> findByColorBotonJpql(@Param("colorBoton") Color colorBoton);

    @Query("SELECT p FROM Piso p WHERE p.sucursal = :sucursal")
    List<Piso> findBySucursalJpql(@Param("sucursal") Sucursal sucursal);
}
