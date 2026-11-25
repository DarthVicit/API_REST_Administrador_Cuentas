package com.administracioncuentas.cuentas.controller;

import com.administracioncuentas.cuentas.dto.CuentaRequestDTO;
import com.administracioncuentas.cuentas.dto.CuentaResponseDTO;
import com.administracioncuentas.cuentas.dto.MovimientoRequestDTO;
import com.administracioncuentas.cuentas.dto.MovimientoResponseDTO;
import com.administracioncuentas.cuentas.repository.IMovimientoRepository;
import com.administracioncuentas.cuentas.service.ICuentaService;
import com.administracioncuentas.cuentas.service.IMovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    ICuentaService cuentaService;
    @Autowired
    IMovimientoService movimientoService;


    @PostMapping("/cuentas")
    public ResponseEntity<CuentaResponseDTO> crearCuenta(@Valid @RequestBody CuentaRequestDTO cuentaRequestDTO){
        CuentaResponseDTO cuentaResponseDTO=cuentaService.crearCuenta(cuentaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cuentaResponseDTO);
    }

    @GetMapping("/cuentas/{id}")
    public ResponseEntity<CuentaResponseDTO> obtenerCuenta(@PathVariable String id){
        CuentaResponseDTO cuentaResponseDTO=cuentaService.trerCuenta(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(cuentaResponseDTO);
    }

    @PostMapping("/cuentas/{id}/depositos")
    public ResponseEntity<MovimientoResponseDTO> hacerDeposito(@PathVariable String id, @RequestBody MovimientoRequestDTO movimientoRequestDTO){
        MovimientoResponseDTO movimientoResponseDTO = movimientoService.hacerDepositos(id,movimientoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movimientoResponseDTO);
    }

    @PostMapping("/cuentas/{id}/retiro")
    public ResponseEntity<MovimientoResponseDTO> hacerRetiro(@PathVariable String id, @RequestBody MovimientoRequestDTO movimientoRequestDTO){
        MovimientoResponseDTO movimientoResponseDTO = movimientoService.hacerRetiro(id,movimientoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movimientoResponseDTO);
    }

    @GetMapping("/cuentas/{id}/movimientos")
    public ResponseEntity<List<MovimientoResponseDTO>> traerMovimientos(@PathVariable String id){
        List<MovimientoResponseDTO> movimientosResponseDTO=movimientoService.traerMovimientos(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movimientosResponseDTO);

    }






}
