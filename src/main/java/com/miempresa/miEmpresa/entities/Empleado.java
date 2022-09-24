package com.miempresa.miEmpresa.entities;

import com.miempresa.miEmpresa.enums.RoleName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class Empleado {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "correoElectronico", unique = true, nullable = false)
    private String correoElectronico;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    // perfil...
    @OneToOne
    @JoinColumn(name = "perfilId")
    private Perfil perfil;

    // rol...
    @ManyToOne
    @JoinColumn(name = "rolId")
    private RoleName rol;

    //empresa...genera error al correr el proyecto
    @ManyToOne
    @JoinColumn(name = "empresaId")
    private Empresa empresa;

    // transacciones...
    @ManyToOne
    @JoinColumn(name = "transaccionesId")
    private Transaccion transacciones;

    @Column(name = "fechaCreado")
    private LocalDate fechaCreado;
    @Column(name = "fechaActualizado")
    private LocalDate fechaActualizado;

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
