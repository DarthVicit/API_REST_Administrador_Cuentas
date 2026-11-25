package com.administracioncuentas.cuentas.dto;

import com.administracioncuentas.cuentas.model.TipoMovimiento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovimientoRequestDTO {

    @NotNull(message = "El monto es obligatorio")
    @PositiveOrZero(message = "El monto debe ser positivo")
    private  Double monto;
    private String descripcion;
}
