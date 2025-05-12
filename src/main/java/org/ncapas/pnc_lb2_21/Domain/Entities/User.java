package org.ncapas.pnc_lb2_21.Domain.Entities;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;

    @Column
    private String firstName;

    @Column
    private String lastName;


//Fecha de nacimiento, correo, contrase;a


}
