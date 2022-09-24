package com.miempresa.miEmpresa.dto;

public class RegistroDTO {

    private String correoElectronico;
    private String contraseña;
    private String validaContraseña;

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
}
