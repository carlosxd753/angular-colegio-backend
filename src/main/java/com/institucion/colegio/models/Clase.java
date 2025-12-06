package com.institucion.colegio.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Clase extends BaseModel{
    private String periodo;
}
