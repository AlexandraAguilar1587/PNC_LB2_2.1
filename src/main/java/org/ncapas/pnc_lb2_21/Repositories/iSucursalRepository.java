package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iSucursalRepository extends iGenericRepository<Sucursal, UUID> {

    // 1) Métodos JPA
    List<Sucursal> findByNombreSucursal(String nombreSucursal);
    List<Sucursal> findByDireccionSucursal(String direccionSucursal);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM sucursal WHERE nombre_sucursal = :nombreSucursal", nativeQuery = true)
    List<Sucursal> findByNombreSucursalNative(@Param("nombreSucursal") String nombreSucursal);

    @Query(value = "SELECT * FROM sucursal WHERE direccion_sucursal = :direccionSucursal", nativeQuery = true)
    List<Sucursal> findByDireccionSucursalNative(@Param("direccionSucursal") String direccionSucursal);

    // 3) Consultas JPQL
    @Query("SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal")
    List<Sucursal> findByNombreSucursalJpql(@Param("nombreSucursal") String nombreSucursal);

    @Query("SELECT s FROM Sucursal s WHERE s.direccionSucursal= :direccionSucursal")
    List<Sucursal> findByDireccionSucursalJpql(@Param("direccionSucursal") String direccionSucursal);
}
