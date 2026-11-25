package com.administracioncuentas.cuentas.service;

import com.administracioncuentas.cuentas.Mapper.CuentaMapper;
import com.administracioncuentas.cuentas.dto.CuentaRequestDTO;
import com.administracioncuentas.cuentas.dto.CuentaResponseDTO;
import com.administracioncuentas.cuentas.model.Cuenta;
import com.administracioncuentas.cuentas.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    ICuentaRepository cuentaRepository;

    private final CuentaMapper cuentaMapper;
    @Autowired
    public CuentaService(CuentaMapper cuentaMapper){
        this.cuentaMapper=cuentaMapper;
    }

    @Override
    public CuentaResponseDTO crearCuenta(CuentaRequestDTO cuentaRequestDTO) {

    Cuenta cuenta= new Cuenta();
    cuenta.setNumeroCuenta(cuentaRequestDTO.getNumeroCuenta());
    cuenta.setTitular(cuentaRequestDTO.getTitular());
    cuenta.setSaldo(cuentaRequestDTO.getSaldo());

    Cuenta cuentaGuardada =cuentaRepository.save(cuenta);

    return cuentaMapper.toDto(cuentaGuardada);
    }

    @Override
    public CuentaResponseDTO trerCuenta(String numeroCuenta) {

        return cuentaMapper.toDto(cuentaRepository.findById(numeroCuenta).orElseThrow(()-> new RuntimeException("No existe la cuenta asociada a ese número de cuenta")));

    }
}
