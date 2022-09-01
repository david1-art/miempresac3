package com.miempresa.miEmpresa.entities;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombrerol")
    private String nombreRol;

    public int getId() {
        return id;
    }

    public String getNombreRol() {
        return nombreRol;
    }
}
