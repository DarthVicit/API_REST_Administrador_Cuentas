package com.administracioncuentas.cuentas.repository;

import com.administracioncuentas.cuentas.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuenta_NumeroCuenta(String numeroCuenta);
}
