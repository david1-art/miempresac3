package com.miempresa.miEmpresa.dto;

import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.entities.Perfil;

import java.time.LocalDate;

public class CreateEmpleadoDTO {

    private String correoElectronico;
    private String contraseña;
    private String validaContraseña;
    private Perfil perfil;
    private Empresa empresa;
    private LocalDate fechaCreado;
    private LocalDate fechaActualizado;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getValidaContraseña() {
        return validaContraseña;
    }

    public void setValidaContraseña(String validaContraseña) {
        this.validaContraseña = validaContraseña;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
