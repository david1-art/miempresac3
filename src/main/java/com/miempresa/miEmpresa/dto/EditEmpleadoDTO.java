package com.miempresa.miEmpresa.dto;

import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.entities.Perfil;
import com.miempresa.miEmpresa.entities.Transaccion;
import com.miempresa.miEmpresa.enums.RoleName;

import java.time.LocalDate;

public class EditEmpleadoDTO {

    private int id;
    private Empresa empresa;
    private Perfil perfil;
    private RoleName rol;
    private Transaccion transacciones;
    private LocalDate fechaActualizado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public RoleName getRol() {
        return rol;
    }

    public void setRol(RoleName rol) {
        this.rol = rol;
    }

    public Transaccion getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }

    public LocalDate getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(LocalDate fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }
}
