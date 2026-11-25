package com.administracioncuentas.cuentas.service;

import com.administracioncuentas.cuentas.dto.CuentaRequestDTO;
import com.administracioncuentas.cuentas.dto.CuentaResponseDTO;
import com.administracioncuentas.cuentas.model.Cuenta;

public interface ICuentaService {
   CuentaResponseDTO crearCuenta(CuentaRequestDTO cuentaRequestDTO);
   CuentaResponseDTO trerCuenta(String numeroCuenta);

}
