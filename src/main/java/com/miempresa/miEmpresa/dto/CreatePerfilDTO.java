package com.miempresa.miEmpresa.dto;

import java.time.LocalDate;

public class CreatePerfilDTO {

    private String imagen;
    private String numeroTelefono;
    private LocalDate fechaCreado;
    private LocalDate fechaActualizado;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public LocalDate getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDate fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public LocalDate getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(LocalDate fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }
}
