package com.administracioncuentas.cuentas.service;

import com.administracioncuentas.cuentas.Mapper.MovimientoMapper;
import com.administracioncuentas.cuentas.dto.CuentaResponseDTO;
import com.administracioncuentas.cuentas.dto.MovimientoRequestDTO;
import com.administracioncuentas.cuentas.dto.MovimientoResponseDTO;
import com.administracioncuentas.cuentas.model.Cuenta;
import com.administracioncuentas.cuentas.model.Movimiento;
import com.administracioncuentas.cuentas.model.TipoMovimiento;
import com.administracioncuentas.cuentas.repository.ICuentaRepository;
import com.administracioncuentas.cuentas.repository.IMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoService implements IMovimientoService{


    private final IMovimientoRepository movimientoRepository;

    private final ICuentaRepository cuentaRepository;

    private final MovimientoMapper movimientoMapper;

    public MovimientoService(MovimientoMapper movimientoMapper,ICuentaRepository cuentaRepository,IMovimientoRepository movimientoRepository){
        this.movimientoMapper=movimientoMapper;
        this.movimientoRepository=movimientoRepository;
        this.cuentaRepository=cuentaRepository;
    }

    @Override
    public MovimientoResponseDTO hacerDepositos(String numeroCuenta, MovimientoRequestDTO movimientoRequestDTO) {
        Cuenta cuenta=cuentaRepository.findById(numeroCuenta).orElseThrow(()-> new RuntimeException("Cuenta no válida"));

        Double saldoNuevo=cuenta.getSaldo()+movimientoRequestDTO.getMonto();
        cuenta.setSaldo(saldoNuevo);

        Movimiento movimiento= new Movimiento();


        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);
        movimiento.setDescripcion(movimientoRequestDTO.getDescripcion());
        movimiento.setMonto(movimientoRequestDTO.getMonto());
        movimiento.setTipoMovimiento(TipoMovimiento.DEPOSITO);

        cuentaRepository.save(cuenta);
        movimientoRepository.save(movimiento);


        return movimientoMapper.toDto(movimiento);
    }

    @Override
    public MovimientoResponseDTO hacerRetiro(String numeroCuenta, MovimientoRequestDTO movimientoRequestDTO) {
        Cuenta cuenta=cuentaRepository.findById(numeroCuenta).orElseThrow(()-> new RuntimeException("Cuenta no válida"));

        Double saldoNuevo=cuenta.getSaldo()-movimientoRequestDTO.getMonto();
        cuenta.setSaldo(saldoNuevo);

        Movimiento movimiento= new Movimiento();


        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);
        movimiento.setDescripcion(movimientoRequestDTO.getDescripcion());
        movimiento.setMonto(movimientoRequestDTO.getMonto());
        movimiento.setTipoMovimiento(TipoMovimiento.RETIRO);

        cuentaRepository.save(cuenta);
        movimientoRepository.save(movimiento);


        return movimientoMapper.toDto(movimiento);
    }

    @Override
    public List<MovimientoResponseDTO> traerMovimientos(String numeroCuenta) {
        List<MovimientoResponseDTO> movimientoResponseDTO= movimientoRepository.findByCuenta_NumeroCuenta(numeroCuenta)
                .stream()
                .map(movimiento -> movimientoMapper.toDto(movimiento) )
                .toList()
                ;


        return movimientoResponseDTO;

    }
}
