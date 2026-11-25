package com.administracioncuentas.cuentas.Mapper;


import com.administracioncuentas.cuentas.dto.MovimientoResponseDTO;
import com.administracioncuentas.cuentas.model.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class MovimientoMapper {
    public MovimientoResponseDTO toDto (Movimiento movimiento){
        return new MovimientoResponseDTO(movimiento.getIdMovimiento(),
                movimiento.getMonto(),
                movimiento.getTipoMovimiento(),
                movimiento.getFecha(),
                movimiento.getDescripcion()
        );

    }
}
