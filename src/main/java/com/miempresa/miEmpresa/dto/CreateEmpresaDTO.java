package com.miempresa.miEmpresa.dto;

import java.time.LocalDate;

public class CreateEmpresaDTO {

    private String nombreEmpresa;
    private String documentoEmpresa;
    private String telefonoEmpresa;
    private String direccionEmpresa;
    private LocalDate fechaCreado;
    private LocalDate fechaModificado;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDocumentoEmpresa() {
        return documentoEmpresa;
    }

    public void setDocumentoEmpresa(String documentoEmpresa) {
        this.documentoEmpresa = documentoEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public LocalDate getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDate fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public LocalDate getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(LocalDate fechaModificado) {
        this.fechaModificado = fechaModificado;
    }
}
