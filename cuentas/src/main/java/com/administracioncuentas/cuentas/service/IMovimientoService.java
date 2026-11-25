package com.administracioncuentas.cuentas.service;

import com.administracioncuentas.cuentas.dto.MovimientoRequestDTO;
import com.administracioncuentas.cuentas.dto.MovimientoResponseDTO;
import com.administracioncuentas.cuentas.model.Movimiento;

import java.util.List;

public interface IMovimientoService {
    MovimientoResponseDTO hacerDepositos(String numeroCuenta, MovimientoRequestDTO movimientoRequestDTO);
    MovimientoResponseDTO hacerRetiro(String numeroCuenta, MovimientoRequestDTO movimientoRequestDTO);
    List<MovimientoResponseDTO> traerMovimientos(String numeroCuenta);


}
