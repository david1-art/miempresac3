package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empresa")
public class Empresa {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombreEmpresa", unique = true, nullable = false)
    private String nombreEmpresa;
    @Column(name = "documentoEmpresa", unique = true, nullable = false)
    private String documentoEmpresa;
    @Column(name = "telefonoEmpresa")
    private String telefonoEmpresa;
    @Column(name = "direccionEmpresa")
    private String direccionEmpresa;

    // usuario...

    // transacciones...
    @ManyToOne
    @JoinColumn(name = "transaccionesId")
    private Transaccion transacciones;

    @Column(name = "fechaCreado")
    private LocalDate fechaCreado;
    @Column(name = "fechaModificado")
    private LocalDate fechaModificado;

    // Getters & Settes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Transaccion getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }
}
