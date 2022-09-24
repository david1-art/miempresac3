package com.miempresa.miEmpresa.dto;

import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.entities.Empresa;

import java.time.LocalDate;

public class CreateTransaccionDTO {

    private String concepto;
    private String monto;
    private Empleado empleado;
    private Empresa empresa;
    private LocalDate fechaCreado;
    private LocalDate fechaActualizado;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
