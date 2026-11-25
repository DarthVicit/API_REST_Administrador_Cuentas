package com.administracioncuentas.cuentas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CuentaRequestDTO {
    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(max = 16, message = "El número de cuenta no debe superar 16 caracteres")
    private String numeroCuenta;
    @NotBlank(message = "El nombre del titular es obligatorio")
    private String titular;
    @NotNull(message = "El saldo es obligatorio")
    @PositiveOrZero(message = "El saldo debe ser positivo")
    private Double saldo;
}
