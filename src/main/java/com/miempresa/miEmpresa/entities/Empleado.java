package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class Empleado {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "correoElectronico", unique = true)
    private String correoElectronico;

    // perfil...
    @OneToOne
    @JoinColumn(name = "perfilId")
    private Perfil perfil;

    // rol...
    @Column(name = "rol")
    private EnumRoleName rolName;

    // empresa...genera error al correr el proyecto
    /*@OneToMany
    @JoinColumn(name = "empresaId")
    private Empresa empresa;*/

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

    public EnumRoleName getRolName() {
        return rolName;
    }

    public void setRolName(EnumRoleName rolName) {
        this.rolName = rolName;
    }

    public Transaccion getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }
}
