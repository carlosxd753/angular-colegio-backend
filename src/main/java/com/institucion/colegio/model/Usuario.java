package com.institucion.colegio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario extends BaseModel{
    private String nombre;
    private String apellidos;
    private String dni;
    private String correo;
    private String password;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="id_clase")
    private Clase clase;
}
