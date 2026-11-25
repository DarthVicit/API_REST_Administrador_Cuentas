package com.administracioncuentas.cuentas.dto;

import com.administracioncuentas.cuentas.model.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovimientoResponseDTO {
    private Long idMovimiento;
    private  Double monto;
    private TipoMovimiento tipoMovimiento;
    private LocalDateTime fecha;
    private String descripcion;
}
