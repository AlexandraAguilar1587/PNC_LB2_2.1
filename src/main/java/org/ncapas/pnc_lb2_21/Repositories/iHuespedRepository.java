package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.Huesped;
import org.ncapas.pnc_lb2_21.Domain.Entities.Persona;
import org.ncapas.pnc_lb2_21.Domain.Entities.Regalia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface iHuespedRepository extends iGenericRepository<Huesped, Integer> {
    // 1) Métodos JPA
    List<Huesped> findByPersona(Persona persona);
    List<Huesped> findByRegalia(Regalia regalia);

    // 2) Consultas nativas
    @Query(value = "SELECT * FROM huesped WHERE persona_id = :personaId", nativeQuery = true)
    List<Huesped> findByPersonaIdNative(@Param("personaId") UUID personaId);

    @Query(value = "SELECT * FROM huesped WHERE regalia_id = :regaliaId", nativeQuery = true)
    List<Huesped> findByRegaliaNative(@Param("regaliaId") UUID regaliaId);

    // 3) Consultas JPQL
    @Query("SELECT h FROM Huesped h WHERE h.persona.personaId = :personaId")
    List<Huesped> findByPersonaJpql(@Param("personaId") UUID personaId);

    @Query("SELECT h FROM Huesped h WHERE h.regalia.idRegalia = :regaliaId")
    List<Huesped> findByRegaliaJpql(@Param("regaliaId") UUID regaliaId);
}
