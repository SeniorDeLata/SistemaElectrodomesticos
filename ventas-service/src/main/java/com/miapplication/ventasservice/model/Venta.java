package com.miapplication.ventasservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Venta {
    private Long id;
    private LocalDate fecha;
    private Long id_carrito;
}
