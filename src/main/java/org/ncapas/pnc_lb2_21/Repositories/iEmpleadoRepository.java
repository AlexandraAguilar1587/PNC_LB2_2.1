package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iEmpleadoRepository extends iGenericRepository<Empleado, UUID> {

    // 1) Métodos derivados
    List<Empleado> findByPersonaPersonaId(UUID personaId);
    List<Empleado> findByDepartamentoIdDepartamento(UUID idDepartamento);
    List<Empleado> findBySucursalIdSucursal(UUID idSucursal);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM empleado WHERE persona_id = :personaId", nativeQuery = true)
    List<Empleado> findByPersonaNative(@Param("personaId") UUID personaId);

    @Query(value = "SELECT * FROM empleado WHERE departamento_id = :idDepartamento", nativeQuery = true)
    List<Empleado> findByDepartamentoNative(@Param("idDepartamento") UUID idDepartamento);

    @Query(value = "SELECT * FROM empleado WHERE sucursal_id = :idSucursal", nativeQuery = true)
    List<Empleado> findBySucursalNative(@Param("idSucursal") UUID idSucursal);

    // 3) Consultas JPQL
    @Query("SELECT e FROM Empleado e WHERE e.persona.personaId = :personaId")
    List<Empleado> findByPersonaJpql(@Param("personaId") UUID personaId);

    @Query("SELECT e FROM Empleado e WHERE e.departamento.idDepartamento = :idDepartamento")
    List<Empleado> findByDepartamentoJpql(@Param("idDepartamento") UUID idDepartamento);

    @Query("SELECT e FROM Empleado e WHERE e.sucursal.idSucursal = :idSucursal")
    List<Empleado> findBySucursalJpql(@Param("idSucursal") UUID idSucursal);
}
