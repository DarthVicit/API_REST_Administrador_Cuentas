package com.administracioncuentas.cuentas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CUENTA")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cuenta {
    @Id
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;

    @Column(name = "TITULAR")
    private String titular;

    @Column(name = "SALDO", nullable = false)
    private Double saldo;

    @OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos;

}
