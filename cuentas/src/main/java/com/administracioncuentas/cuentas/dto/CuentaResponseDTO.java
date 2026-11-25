package com.administracioncuentas.cuentas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CuentaResponseDTO {
    private String numeroCuenta;
    private String titular;
    private Double saldo;
    private List<MovimientoResponseDTO> movimientos;
}
