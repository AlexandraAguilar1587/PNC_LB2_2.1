package org.ncapas.pnc_lb2_21.Repositories;

import org.ncapas.pnc_lb2_21.Domain.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface iUserRepository extends iGenericRepository<User, UUID> {
/**aca siempre trabajar siempre con la clase que se declara arriba,en este caso solo se ocupara la clase USER**/

    /**
     * Trabajando con funciones JPA
     **/
    public User findByCorreo(String correo);
    public User findByContrasena(String contrasena);

    /**Query Nativa, aca si se escribe EL NOMBRE DE LA TABLA Y NO DE LA CLASE**/
    @Query(nativeQuery = true,value = "SELECT *FROM user_data WHERE user_data.correo= :correo")
    public User findByCorreoNative(@Param("correo") String correo);
    @Query(value = "SELECT * FROM user_data WHERE contrasena = :contrasena", nativeQuery = true)
    public User findByContrasenaNative(@Param("contrasena") String contrasena);

    /**Querys hibridas(combinacion entre querys nativaas y JPA**/
    /**Seleccioname el objeto completo desde la clase USER alias us
     *
     * @Query("SELECT u       // 1️⃣ Qué quiero devolver: el alias “u”
     *      FROM User u       // 2️⃣ Dónde lo saco: de la entidad User, a la que llamo “u”
     *     WHERE u.rol.nombre = :rolNombre")
     * **/
    @Query("SELECT u FROM User u WHERE u.correo = :correo")
    public User findByCorreoJpql(@Param("correo") String correo);

    @Query("SELECT u FROM User u WHERE u.contrasena = :contrasena")
    public User findByContrasenaJpql(@Param("contrasena") String contrasena);










}
