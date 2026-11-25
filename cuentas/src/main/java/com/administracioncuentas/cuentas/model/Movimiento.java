package com.administracioncuentas.cuentas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "MOVIMIENTO")
public class Movimiento {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "movimiento_seq")
            @SequenceGenerator(name = "movimiento_seq",
            sequenceName = "SEQ_MOVIMIENTO",
            allocationSize = 1)
    @Column(name="ID_MOVIMIENTO")

    private Long idMovimiento;

    @Column (name="MONTO")
    private  Double monto;

    @Column(name="TIPO_MOVIMIENTO")
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    @Column (name="FECHA")
    private LocalDateTime fecha;

    @Column (name="DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn (name = "NUMERO_CUENTA", nullable = false)
    private Cuenta cuenta;


}
