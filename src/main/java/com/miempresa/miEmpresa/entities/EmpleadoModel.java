package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "correo", unique = true)
    private String correo;

    // perfil...
    @OneToOne
    @JoinColumn(name = "perfilId")
    private PerfilModel perfil;

    // rol...
    @ManyToOne
    @JoinColumn(name = "rolId")
    private RolModel rol;

    // empresa...genera error al correr el proyecto
    /*@OneToMany
    @JoinColumn(name = "empresaId")
    private EmpresaModel empresa;*/

    // transaccion...
    @ManyToOne
    @JoinColumn(name = "transaccionId")
    private TransaccionModel transaccion;

    @Column(name = "creado")
    private LocalDate creado;
    @Column(name = "actualizado")
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

    public PerfilModel getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilModel perfil) {
        this.perfil = perfil;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }

    public TransaccionModel getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(TransaccionModel transaccion) {
        this.transaccion = transaccion;
    }
}
