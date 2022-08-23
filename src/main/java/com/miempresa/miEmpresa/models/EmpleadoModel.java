package com.miempresa.miEmpresa.models;

import java.time.LocalDate;

public class EmpleadoModel {
    // Atributos
    private int id;
    private String correo;
    // perfil...
    // rol...
    // empresa...
    // transaccion...
    private LocalDate creado;
    private LocalDate actualizado;

    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public LocalDate getActualizado() {
        return actualizado;
    }

    public void setActualizado(LocalDate actualizado) {
        this.actualizado = actualizado;
    }
}
