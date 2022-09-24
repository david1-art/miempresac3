package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InterfaceEmpleado extends JpaRepository<Empleado, Integer> {

    // Query para validar ingreso por login -- aun no usamos login
    @Query("SELECT e FROM Empleado e WHERE e.correoElectronico = ?1 and e.contraseña = ?2")
    ArrayList<Empleado> validarCredenciales(String correoElectronico, String contraseña);

    // Query para validar que el correo no se repita
    @Query("SELECT e FROM Empleado e WHERE e.correoElectronico = ?1")
    ArrayList<Empleado> validarCorreoEmpleado(String correoElectronico);

    @Query("SELECT e FROM Empleado e WHERE e.correoElectronico = ?1")
    Empleado findByUserName (String correoElectronico);
}
