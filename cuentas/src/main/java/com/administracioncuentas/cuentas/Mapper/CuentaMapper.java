package com.administracioncuentas.cuentas.Mapper;

import com.administracioncuentas.cuentas.dto.CuentaResponseDTO;
import com.administracioncuentas.cuentas.dto.MovimientoResponseDTO;
import com.administracioncuentas.cuentas.model.Cuenta;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class CuentaMapper {
    private final MovimientoMapper movimientoMapper;

    public CuentaMapper(MovimientoMapper movimientoMapper){
        this.movimientoMapper=movimientoMapper;
    }



    public CuentaResponseDTO toDto(Cuenta cuenta){

        List<MovimientoResponseDTO> movimientos =
                cuenta.getMovimientos() == null
                        ? List.of()
                        : cuenta.getMovimientos()
                        .stream()
                        .map(movimientoMapper::toDto)
                        .toList();

        return new CuentaResponseDTO(cuenta.getNumeroCuenta(),
                cuenta.getTitular(),
                cuenta.getSaldo(),
                 movimientos
        );


    }


}
