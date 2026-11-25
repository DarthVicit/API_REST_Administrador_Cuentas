package com.administracioncuentas.cuentas.repository;

import com.administracioncuentas.cuentas.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository< Cuenta,String> {
}
